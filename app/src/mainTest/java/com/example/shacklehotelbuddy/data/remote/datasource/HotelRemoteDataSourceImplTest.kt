package com.example.shacklehotelbuddy.data.remote.datasource

import com.example.shacklehotelbuddy.data.mock.MockHotelSearch
import com.example.shacklehotelbuddy.domain.model.Either
import com.example.shacklehotelbuddy.domain.model.Failure
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import com.example.shacklehotelbuddy.domain.remote.datasource.HotelRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HotelRemoteDataSourceImplTest @Inject constructor(): HotelRemoteDataSource {

    override suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, Failure>> {
        return flow { emit(Either.success(MockHotelSearch.hotelList)) }
    }

}
