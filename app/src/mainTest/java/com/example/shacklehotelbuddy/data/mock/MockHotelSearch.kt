package com.example.shacklehotelbuddy.data.mock

import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import com.example.shacklehotelbuddy.domain.model.SearchDate

object MockHotelSearch {

    val searchDate = SearchDate("1", "1", "2000")
    val hotelSearch = HotelSearch(searchDate, searchDate, 1, 0)
    val hotelSearchList = listOf(hotelSearch)

    val hotel = Hotel("", "", "", "", "", "", )
    val hotelList = listOf(hotel)
}
