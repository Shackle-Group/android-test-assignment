package com.example.shacklehotelbuddy.data.local.datasource

import com.example.shacklehotelbuddy.data.local.database.HotelSearchDao
import com.example.shacklehotelbuddy.data.mapper.toHotelSearch
import com.example.shacklehotelbuddy.data.mapper.toHotelSearchEntity
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

interface HotelLocalDataSource {
    suspend fun cacheHotelSearch(hotelSearch: HotelSearch)
    suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>>
}

@Singleton
class HotelLocalDataSourceImpl @Inject constructor(
    private val hotelSearchDao: HotelSearchDao
): HotelLocalDataSource {

    override suspend fun cacheHotelSearch(hotelSearch: HotelSearch) {
        hotelSearchDao.getCachedHotelSearches().collect {
            if (!it.map { hotel -> hotel.toHotelSearch() }.contains(hotelSearch)) {
                hotelSearchDao.cacheHotelSearch(hotelSearch.toHotelSearchEntity())
            }
        }
    }

    override suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>> {
        return flow {
            hotelSearchDao.getCachedHotelSearches().collect {
                emit(it.map { hotel -> hotel.toHotelSearch() }.reversed())
//                it.forEach { a ->
//                    hotelSearchDao.deleteHotelSearch(it)
//                }
            }
        }
    }
}
