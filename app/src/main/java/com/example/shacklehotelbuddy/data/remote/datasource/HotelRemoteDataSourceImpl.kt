package com.example.shacklehotelbuddy.data.remote.datasource

import com.example.shacklehotelbuddy.data.mapper.NetworkErrorMapper
import com.example.shacklehotelbuddy.data.mapper.mapCheckInDate
import com.example.shacklehotelbuddy.data.mapper.toHotelList
import com.example.shacklehotelbuddy.data.remote.model.Child
import com.example.shacklehotelbuddy.data.remote.model.HotelRoom
import com.example.shacklehotelbuddy.data.remote.model.HotelSearchRequest
import com.example.shacklehotelbuddy.data.remote.model.NetworkError
import com.example.shacklehotelbuddy.data.remote.service.HotelSearchService
import com.example.shacklehotelbuddy.domain.core.Either
import com.example.shacklehotelbuddy.domain.model.hotelsearch.Hotel
import com.example.shacklehotelbuddy.domain.model.hotelsearch.HotelSearch
import com.example.shacklehotelbuddy.domain.remote.datasource.HotelRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HotelRemoteDataSourceImpl @Inject constructor(
    private val service: HotelSearchService
): HotelRemoteDataSource {

    override suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, NetworkError>> =
        flow {
            hotelSearch.apply {
                // covert number of children to list with default age
                val childrenList = mutableListOf<Child>()
                for (i in 1..children) {
                    childrenList.add(Child())
                }
                // rooms for filter with adults and list of children
                val rooms = listOf(HotelRoom(adults, childrenList))

                runCatching {
                    service.searchHotels(
                        HotelSearchRequest(
                            rooms = rooms,
                            checkInDate = checkInDate.mapCheckInDate(),
                            checkOutDate = checkOutDate.mapCheckInDate()
                        )
                    )
                }.map {
                    emit(
                        if (it.isSuccessful && it.body() != null) {
                            Either.success(it.body()!!.toHotelList())
                        } else {
                            // parse error to proper network error
                            Either.Fail(NetworkErrorMapper.toErrorCause(response = it))
                        }
                    )
                }.onFailure {
                    // map error to proper message
                    emit(Either.Fail(NetworkErrorMapper.toErrorCause(throwable = it)))
                }
            }
        }
}