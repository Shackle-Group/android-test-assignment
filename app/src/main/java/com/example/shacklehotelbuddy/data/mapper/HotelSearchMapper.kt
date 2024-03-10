package com.example.shacklehotelbuddy.data.mapper

import com.example.shacklehotelbuddy.data.local.model.HotelSearchEntity
import com.example.shacklehotelbuddy.data.remote.model.HotelSearchResponse
import com.example.shacklehotelbuddy.data.remote.model.Reviews
import com.example.shacklehotelbuddy.domain.core.AppConstants.PLACEHOLDER_NO_REVIEWS
import com.example.shacklehotelbuddy.domain.core.AppConstants.PLACEHOLDER_UNAVAILABLE_VALUE
import com.example.shacklehotelbuddy.domain.model.hotelsearch.Hotel
import com.example.shacklehotelbuddy.domain.model.hotelsearch.HotelSearch


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
                reviews = parseReview(it.reviews)
            )
        )
    }
    return list
}

fun parseReview(reviews: Reviews?): String {
    var rating = PLACEHOLDER_NO_REVIEWS
    runCatching {
        reviews?.apply {
            if (!total.isNullOrEmpty() && !score.isNullOrEmpty() && total.toInt() > 0) {
                rating = "$score($total reviews)"
            }
        }
    }
    return rating
}
