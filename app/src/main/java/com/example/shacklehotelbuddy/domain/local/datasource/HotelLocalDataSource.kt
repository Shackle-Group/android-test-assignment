package com.example.shacklehotelbuddy.domain.local.datasource

import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow

interface HotelLocalDataSource {
    suspend fun cacheHotelSearch(hotelSearch: HotelSearch)
    suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>>
}