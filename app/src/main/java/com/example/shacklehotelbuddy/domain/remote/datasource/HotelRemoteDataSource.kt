package com.example.shacklehotelbuddy.domain.remote.datasource

import com.example.shacklehotelbuddy.domain.model.Either
import com.example.shacklehotelbuddy.domain.model.Failure
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow

interface HotelRemoteDataSource {
    suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, Failure>>
}

