package com.example.shacklehotelbuddy.features.hotels.useCases

import com.example.shacklehotelbuddy.base.api.useCases.ApiUseCase
import com.example.shacklehotelbuddy.features.hotels.api.SearchApiRepository
import com.example.shacklehotelbuddy.features.hotels.api.request.CheckDateRequest
import com.example.shacklehotelbuddy.features.hotels.api.request.ChildRequest
import com.example.shacklehotelbuddy.features.hotels.api.request.HotelSearchRequest
import com.example.shacklehotelbuddy.features.hotels.api.request.RoomRequest
import java.util.Calendar
import javax.inject.Inject

// Can contains some combined logic. For example for saving to db.
class SearchUseCase @Inject constructor(
    private val searchApiRepository: SearchApiRepository
) : ApiUseCase() {
    suspend fun getHotels(
        checkInDate: Calendar,
        checkOutDate: Calendar,
        adultCount: Int,
        childrenCount: Int,
    ) = searchApiRepository.getHotels(
        hotelSearchRequest = HotelSearchRequest.getInstance(
            checkInDate = checkInDate.getCheckDateRequest(),
            checkOutDate = checkOutDate.getCheckDateRequest(),
            rooms = listOf(
                RoomRequest(
                    adults = adultCount.toLong(),
                    children = ArrayList<ChildRequest>().apply {
                        repeat(childrenCount) { add(ChildRequest(age = 5)) }
                    }
                )
            )
        )
    )

    private fun Calendar.getCheckDateRequest() = CheckDateRequest(
        day = get(Calendar.DAY_OF_MONTH).toLong(),
        month = get(Calendar.MONTH).toLong(),
        year = get(Calendar.YEAR).toLong()
    )
}