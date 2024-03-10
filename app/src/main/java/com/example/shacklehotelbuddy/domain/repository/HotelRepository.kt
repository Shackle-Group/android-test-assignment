package com.example.shacklehotelbuddy.domain.repository

import com.example.shacklehotelbuddy.data.remote.model.NetworkError
import com.example.shacklehotelbuddy.domain.core.Either
import com.example.shacklehotelbuddy.domain.model.hotelsearch.Hotel
import com.example.shacklehotelbuddy.domain.model.hotelsearch.HotelSearch
import kotlinx.coroutines.flow.Flow

interface HotelRepository {
    /**
     * fetches list of hotels based on [hotelSearch] from remote data source
     * @param hotelSearch user selected search filter
     * @return Either object of Success with list of hotels or [NetworkError]
     * */
    suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, NetworkError>>

    /**
     * caching current search in the local data source
     * @param hotelSearch user selected search filter
     * */
    suspend fun cacheHotelSearch(hotelSearch: HotelSearch)

    /**
     * Fetches list of hotel search from local data source
     * @return list of [HotelSearch]
     * */
    suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>>
}