package com.adrianczuczka.data.properties

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.adrianczuczka.data.properties.local.PropertiesDatabase
import com.adrianczuczka.data.properties.local.mapper.ApiPropertyToDbPropertyMapper
import com.adrianczuczka.data.properties.local.model.DbProperty
import com.adrianczuczka.data.properties.local.model.DbSearchInfo
import com.adrianczuczka.data.properties.local.remotekey.RemoteKey
import com.adrianczuczka.data.properties.remote.PropertiesService
import com.adrianczuczka.data.properties.remote.mapper.DbSearchInfoToApiSearchInfoMapper

@OptIn(ExperimentalPagingApi::class)
class PropertiesRemoteMediator(
    private val service: PropertiesService,
    private val database: PropertiesDatabase,
    private val dbSearchInfo: DbSearchInfo,
    private val apiPropertyToDbPropertyMapper: ApiPropertyToDbPropertyMapper,
    private val dbSearchInfoToApiSearchInfoMapper: DbSearchInfoToApiSearchInfoMapper,
) : RemoteMediator<Int, DbProperty>() {

    private val propertiesDao by lazy { database.propertiesDao() }
    private val remoteKeyDao by lazy { database.remoteKeyDao() }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, DbProperty>,
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND ->
                    return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val remoteKey = database.withTransaction {
                        remoteKeyDao.remoteKeyBySearchInfo(dbSearchInfo)
                    }

                    if (remoteKey.nextKey == null) {
                        return MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    }

                    remoteKey.nextKey
                }
            }

            val apiSearchInfo = dbSearchInfoToApiSearchInfoMapper(dbSearchInfo = dbSearchInfo)

            val response = service.getProperties(
                destination = apiSearchInfo.destination,
                checkInDate = apiSearchInfo.checkInDate,
                checkOutDate = apiSearchInfo.checkOutDate,
                rooms = apiSearchInfo.rooms,
                resultsStartingIndex = loadKey,
            )

            val isEndOfList = loadKey == response.summary.matchedPropertiesSize - 1
            val nextKey = if (!isEndOfList) loadKey + 1 else null

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    remoteKeyDao.deleteBySearchInfo(dbSearchInfo)
                    propertiesDao.deleteBySearchInfo(dbSearchInfo)
                }

                remoteKeyDao.insertOrReplace(
                    RemoteKey(dbSearchInfo, nextKey)
                )
                propertiesDao.insertAll(response.properties.map { apiPropertyToDbPropertyMapper(it) })
            }

            MediatorResult.Success(
                endOfPaginationReached = isEndOfList
            )
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }
}