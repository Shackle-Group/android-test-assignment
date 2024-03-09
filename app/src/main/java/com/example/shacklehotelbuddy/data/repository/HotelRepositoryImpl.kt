package com.example.shacklehotelbuddy.data.repository

import com.example.shacklehotelbuddy.domain.local.datasource.HotelLocalDataSource
import com.example.shacklehotelbuddy.domain.remote.datasource.HotelRemoteDataSource
import com.example.shacklehotelbuddy.domain.model.Either
import com.example.shacklehotelbuddy.domain.model.Failure
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import com.example.shacklehotelbuddy.domain.repository.HotelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HotelRepositoryImpl @Inject constructor(
    private val remoteDataSource: HotelRemoteDataSource,
    private val localDataSource: HotelLocalDataSource
) : HotelRepository {

    override suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, Failure>> {
        return remoteDataSource.searchHotels(hotelSearch)
    }

    override suspend fun cacheHotelSearch(hotelSearch: HotelSearch) {
        localDataSource.cacheHotelSearch(hotelSearch)
    }

    override suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>> {
        return localDataSource.getCachedHotelSearches()
    }
}