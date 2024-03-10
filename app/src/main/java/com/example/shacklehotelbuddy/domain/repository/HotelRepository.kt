package com.example.shacklehotelbuddy.domain.repository

import com.example.shacklehotelbuddy.data.remote.model.NetworkError
import com.example.shacklehotelbuddy.domain.core.Either
import com.example.shacklehotelbuddy.domain.model.hotelsearch.Hotel
import com.example.shacklehotelbuddy.domain.model.hotelsearch.HotelSearch
import kotlinx.coroutines.flow.Flow

interface HotelRepository {
    suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, NetworkError>>
    suspend fun cacheHotelSearch(hotelSearch: HotelSearch)
    suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>>
}