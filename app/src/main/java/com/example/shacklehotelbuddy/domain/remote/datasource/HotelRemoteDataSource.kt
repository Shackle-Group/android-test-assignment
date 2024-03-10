package com.example.shacklehotelbuddy.domain.remote.datasource

import com.example.shacklehotelbuddy.data.remote.model.NetworkError
import com.example.shacklehotelbuddy.domain.core.Either
import com.example.shacklehotelbuddy.domain.model.hotelsearch.Hotel
import com.example.shacklehotelbuddy.domain.model.hotelsearch.HotelSearch
import kotlinx.coroutines.flow.Flow

interface HotelRemoteDataSource {
    /**
     * Remote call to the endpoint to fetch list of hotels based on [hotelSearch]
     * @param hotelSearch user selected search filter
     * @return Either object of Success with list of hotels or [NetworkError]
     * */
    suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, NetworkError>>
}

