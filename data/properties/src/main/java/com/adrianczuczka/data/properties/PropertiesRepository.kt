package com.adrianczuczka.data.properties

import androidx.paging.PagingSource
import com.adrianczuczka.data.properties.local.PropertiesDatabase
import com.adrianczuczka.data.properties.local.mapper.ApiPropertyToDbPropertyMapper
import com.adrianczuczka.data.properties.local.model.DbProperty
import com.adrianczuczka.data.properties.local.model.DbSearchInfo
import com.adrianczuczka.data.properties.remote.PropertiesService
import com.adrianczuczka.data.properties.remote.mapper.DbSearchInfoToApiSearchInfoMapper
import javax.inject.Inject

class PropertiesRepository @Inject constructor(
    private val service: PropertiesService,
    private val database: PropertiesDatabase,
    private val apiPropertyToDbPropertyMapper: ApiPropertyToDbPropertyMapper,
    private val dbSearchInfoToApiSearchInfoMapper: DbSearchInfoToApiSearchInfoMapper,
) {

    fun getPropertiesRemoteMediator(searchInfo: DbSearchInfo): PropertiesRemoteMediator =
        PropertiesRemoteMediator(
            service = service,
            database = database,
            dbSearchInfo = searchInfo,
            apiPropertyToDbPropertyMapper = apiPropertyToDbPropertyMapper,
            dbSearchInfoToApiSearchInfoMapper = dbSearchInfoToApiSearchInfoMapper
        )

    fun getPropertiesPagingSource(searchInfo: DbSearchInfo): PagingSource<Int, DbProperty> =
        database
            .propertiesDao()
            .pagingSource(searchInfo)
}