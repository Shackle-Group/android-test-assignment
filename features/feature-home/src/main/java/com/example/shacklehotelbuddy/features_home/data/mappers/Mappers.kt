package com.example.shacklehotelbuddy.features_home.data.mappers

import com.example.shacklehotelbuddy.core_database.entities.SearchQueryEntity
import com.example.shacklehotelbuddy.features_home.data.dto.CheckInDate
import com.example.shacklehotelbuddy.features_home.data.dto.CheckOutDate
import com.example.shacklehotelbuddy.features_home.data.dto.Children
import com.example.shacklehotelbuddy.features_home.data.dto.Destination
import com.example.shacklehotelbuddy.features_home.data.dto.Room
import com.example.shacklehotelbuddy.features_home.data.dto.SearchRequestDto
import java.util.Date


fun SearchRequestDto.toSearchQueryEntity(): SearchQueryEntity = SearchQueryEntity(
    checkInDate = if (checkInDate?.year == null) Date() else Date(
        checkInDate.year,
        checkInDate.month ?: 1,
        checkInDate.day ?: 1
    ),
    adultsCount = this.rooms?.firstOrNull()?.adults ?: 0,
    childrenCount = this.rooms?.firstOrNull()?.children?.count() ?: 0,
    checkoutDate = if (checkOutDate?.year == null) Date() else Date(),
)

fun SearchQueryEntity.toSearchRequestDto(): SearchRequestDto = SearchRequestDto(
    currency = "EUR",
    eapid = 1,
    locale = "en_US",
    siteId = 300000001,
    destination = Destination(regionId = "6054439"),
    checkInDate = checkInDate.toCheckInDate(),
    checkOutDate = checkoutDate.toCheckOutDate(),
    rooms = arrayListOf(Room(adults = adultsCount, children = createChildren(childrenCount))),
    resultsStartingIndex = 0,
    resultsSize = 100,
    sort = "PRICE_LOW_TO_HIGH",
    filters = null

)

fun createChildren(count: Int = 0): List<Children> {
    val children = mutableListOf<Children>()
    for (i in 0 until count) {
        children.add(Children(i))
    }
    return children.toList()
}

fun Date.toCheckInDate(): CheckInDate = CheckInDate(
    year = year,
    month = month,
    day = day
)

fun Date.toCheckOutDate(): CheckOutDate = CheckOutDate(
    year = year ?: 1972,
    month = month,
    day = day
)

