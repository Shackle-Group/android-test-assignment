package com.example.shacklehotelbuddy.data.remote.datasource

import com.example.shacklehotelbuddy.data.mapper.toHotelList
import com.example.shacklehotelbuddy.data.remote.model.Child
import com.example.shacklehotelbuddy.data.remote.service.HotelSearchService
import com.example.shacklehotelbuddy.domain.model.Either
import com.example.shacklehotelbuddy.domain.model.Failure
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import com.example.shacklehotelbuddy.domain.remote.datasource.HotelRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HotelRemoteDataSourceImpl @Inject constructor(
    private val service: HotelSearchService
): HotelRemoteDataSource {

    /**
     * Remote call to the endpoint to fetch list of hotels based on [hotelSearch]
     * @param hotelSearch user selected search filter
     * */
    override suspend fun searchHotels(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, Failure>> =
        flow {
            hotelSearch.apply {
                val childrenList = mutableListOf<Child>()
                for (i in 1..children) {
                    childrenList.add(Child())
                }

                val result = service.searchHotels(
                    checkInDate = checkInDate.toBookingFormat(),
                    checkOutDate = checkOutDate.toBookingFormat(),
                    adults = adults.toString(),
                    children = children.toString()
                )
                val hotels = result.body()

                emit(
                    if (result.isSuccessful && hotels != null) {
                        Either.success(hotels.toHotelList())
                    } else {
                        Either.fail(Failure.NetworkError)
                    }
                )

//            val result = service.searchHotels(
//                HotelSearchRequest(
//                    rooms = listOf(Room(adults, childrenList)),
//                    checkInDate = checkInDate,
//                    checkOutDate = checkOutDate
//                )
//            )
//
//            val search = result.body()?.data?.propertySearch
//            emit(if (result.isSuccessful && search != null) {
//                Either.success(search.toHotelList())
//            } else {
//                Either.fail(Failure.NetworkError)
//            })

//            // mock data
//            delay(100)
//            emit(Either.success(mockHotelList))
//            emit(Either.success(emptyList()))
//            emit(Either.fail(Failure.NetworkError))
            }
        }
}