package com.example.shacklehotelbuddy.data.mapper

import com.example.shacklehotelbuddy.data.local.model.HotelSearchEntity
import com.example.shacklehotelbuddy.data.remote.model.PropertySearch
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import com.example.shacklehotelbuddy.domain.model.SearchDate


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
        checkInDate = checkInDate.parseToString(),
        checkOutDate = checkOutDate.parseToString(),
        adults = adults,
        children = children
    )
}

fun SearchDate.parseToString(): String {
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

fun PropertySearch.toHotelList(): List<Hotel> {
    return properties.map {
        Hotel(
            id = it.id ?: "",
            name = it.name ?: "",
            imageUrl = it.propertyImage?.image?.url ?: "",
            price = it.price?.lead?.formatted ?: "",//todo check what's missing,
            location = it.neighborhood?.name ?: "",
            star = it.star ?: ""
        )
    }
}

fun parseSearchDate(day: Int, month: Int, year: Int): SearchDate {
    return SearchDate(day.toString(), month.toString(), year.toString())
}