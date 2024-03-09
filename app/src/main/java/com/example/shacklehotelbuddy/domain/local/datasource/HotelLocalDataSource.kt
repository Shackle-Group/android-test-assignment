package com.example.shacklehotelbuddy.domain.local.datasource

import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow

interface HotelLocalDataSource {
    /**
     * caching current search in the local data source
     * @param hotelSearch user selected search filter
     * */
    suspend fun cacheHotelSearch(hotelSearch: HotelSearch)


    /**
     * Fetches list of hotel search cached in database
     * @return list of [HotelSearch]
     * */
    suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>>
}