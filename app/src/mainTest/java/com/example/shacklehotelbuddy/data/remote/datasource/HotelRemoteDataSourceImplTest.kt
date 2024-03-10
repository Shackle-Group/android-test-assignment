package com.example.shacklehotelbuddy.data.remote.datasource

import com.example.shacklehotelbuddy.data.mock.MockHotelSearch
import com.example.shacklehotelbuddy.data.remote.model.NetworkError
import com.example.shacklehotelbuddy.domain.core.Either
import com.example.shacklehotelbuddy.domain.model.hotelsearch.Hotel
import com.example.shacklehotelbuddy.domain.model.hotelsearch.HotelSearch
import com.example.shacklehotelbuddy.domain.remote.datasource.HotelRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HotelRemoteDataSourceImplTest @Inject constructor(): HotelRemoteDataSource {

    override suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, NetworkError>> {
        return flow { emit(Either.success(MockHotelSearch.hotelList)) }
    }

}
