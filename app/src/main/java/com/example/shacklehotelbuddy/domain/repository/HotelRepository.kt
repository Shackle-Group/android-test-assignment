package com.example.shacklehotelbuddy.domain.repository

import com.example.shacklehotelbuddy.domain.model.Either
import com.example.shacklehotelbuddy.domain.model.Failure
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow

interface HotelRepository {
    suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, Failure>>
    suspend fun cacheHotelSearch(hotelSearch: HotelSearch)
    suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>>
}