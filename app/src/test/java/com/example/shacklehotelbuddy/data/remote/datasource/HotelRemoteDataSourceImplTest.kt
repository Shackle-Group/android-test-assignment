package com.example.shacklehotelbuddy.data.remote.datasource

import com.example.shacklehotelbuddy.domain.model.Either
import com.example.shacklehotelbuddy.domain.model.Failure
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HotelRemoteDataSourceImplTest @Inject constructor(): HotelRemoteDataSource {

    override suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, Failure>> {
        TODO("Not yet implemented")
    }

}
