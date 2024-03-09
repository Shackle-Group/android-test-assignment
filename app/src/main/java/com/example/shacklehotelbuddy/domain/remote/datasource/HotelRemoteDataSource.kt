package com.example.shacklehotelbuddy.domain.remote.datasource

import com.example.shacklehotelbuddy.domain.model.Either
import com.example.shacklehotelbuddy.domain.model.Failure
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow

interface HotelRemoteDataSource {
    /**
     * Remote call to the endpoint to fetch list of hotels based on [hotelSearch]
     * @param hotelSearch user selected search filter
     * @return Either object of Success with list of hotels or Failure
     * */
    suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, Failure>>
}

