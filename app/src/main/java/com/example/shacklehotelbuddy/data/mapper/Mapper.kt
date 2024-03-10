package com.example.shacklehotelbuddy.data.mapper

import com.example.shacklehotelbuddy.data.local.model.HotelSearchEntity
import com.example.shacklehotelbuddy.data.remote.model.CheckInDate
import com.example.shacklehotelbuddy.data.remote.model.HotelSearchResponse
import com.example.shacklehotelbuddy.domain.core.AppConstants.PLACEHOLDER_UNAVAILABLE_VALUE
import com.example.shacklehotelbuddy.domain.model.hotelsearch.Hotel
import com.example.shacklehotelbuddy.domain.model.hotelsearch.HotelSearch
import com.example.shacklehotelbuddy.domain.model.hotelsearch.SearchDate


fun HotelSearchEntity.toHotelSearch(): HotelSearch {
    return HotelSearch(
        checkInDate = checkInDate.toSearchDate(),
        checkOutDate = checkOutDate.toSearchDate(),
        adults = adults,
        children = children
    )
}

fun HotelSearch.toHotelSearchEntity(): HotelSearchEntity {
    return HotelSearchEntity(
        checkInDate = checkInDate.parseToFormattedString(),
        checkOutDate = checkOutDate.parseToFormattedString(),
        adults = adults,
        children = children
    )
}

fun SearchDate.parseToFormattedString(): String {
    return "$day/$month/$year"
}

fun String.toSearchDate(): SearchDate {
    return try {
        val slices = this.split("/").take(3)
        SearchDate(slices[0], slices[1], slices[2])
    } catch (e: Exception) {
        SearchDate("", "", "")
    }
}

fun SearchDate.mapCheckInDate(): CheckInDate {
    return try {
        CheckInDate(
            this.day.toInt(),
            this.month.toInt(),
            this.year.toInt()
        )
    } catch (e: Exception) {
        CheckInDate(1, 1, 2025)
    }
}

fun HotelSearchResponse.toHotelList(): List<Hotel> {
    val list = mutableListOf<Hotel>()
    data?.propertySearch?.properties?.forEach {
        list.add(
            Hotel(
                id = it.id ?: PLACEHOLDER_UNAVAILABLE_VALUE,
                name = it.name ?: PLACEHOLDER_UNAVAILABLE_VALUE,
                imageUrl = it.propertyImage?.image?.url ?: PLACEHOLDER_UNAVAILABLE_VALUE,
                price = it.price?.options?.firstOrNull()?.formattedDisplayPrice
                    ?: PLACEHOLDER_UNAVAILABLE_VALUE,
                location = it.neighborhood?.name ?: PLACEHOLDER_UNAVAILABLE_VALUE,
                star = it.star ?: PLACEHOLDER_UNAVAILABLE_VALUE
            )
        )
    }
    return list
}

fun parseSearchDate(day: Int, month: Int, year: Int): SearchDate {
    return SearchDate(day.toString(), month.toString(), year.toString())
}