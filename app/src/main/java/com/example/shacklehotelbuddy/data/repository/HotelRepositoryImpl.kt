package com.example.shacklehotelbuddy.data.repository

import com.example.shacklehotelbuddy.data.remote.model.NetworkError
import com.example.shacklehotelbuddy.domain.local.datasource.HotelLocalDataSource
import com.example.shacklehotelbuddy.domain.core.Either
import com.example.shacklehotelbuddy.domain.model.hotelsearch.Hotel
import com.example.shacklehotelbuddy.domain.model.hotelsearch.HotelSearch
import com.example.shacklehotelbuddy.domain.remote.datasource.HotelRemoteDataSource
import com.example.shacklehotelbuddy.domain.repository.HotelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HotelRepositoryImpl @Inject constructor(
    private val remoteDataSource: HotelRemoteDataSource,
    private val localDataSource: HotelLocalDataSource
) : HotelRepository {

    override suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, NetworkError>> {
        return remoteDataSource.searchHotels(hotelSearch)
    }

    override suspend fun cacheHotelSearch(hotelSearch: HotelSearch) {
        localDataSource.cacheHotelSearch(hotelSearch)
    }

    override suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>> {
        return localDataSource.getCachedHotelSearches()
    }
}