package com.example.shacklehotelbuddy.features_home.data.dto


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchRequestDto(
    @SerialName("checkInDate")
    val checkInDate: CheckInDate?,
    @SerialName("checkOutDate")
    val checkOutDate: CheckOutDate?,
    @SerialName("currency")
    val currency: String?,
    @SerialName("destination")
    val destination: Destination?,
    @SerialName("eapid")
    val eapid: Int?,
    @SerialName("filters")
    val filters: Filters?,
    @SerialName("locale")
    val locale: String?,
    @SerialName("resultsSize")
    val resultsSize: Int?,
    @SerialName("resultsStartingIndex")
    val resultsStartingIndex: Int?,
    @SerialName("rooms")
    val rooms: List<Room?>?,
    @SerialName("siteId")
    val siteId: Int?,
    @SerialName("sort")
    val sort: String?
)

@Keep
@Serializable
data class Room(
    @SerialName("adults")
    val adults: Int?,
    @SerialName("children")
    val children: List<Children?>?
)

@Keep
@Serializable
data class CheckInDate(
    @SerialName("day")
    val day: Int?,
    @SerialName("month")
    val month: Int?,
    @SerialName("year")
    val year: Int?
)


@Keep
@Serializable
data class CheckOutDate(
    @SerialName("day")
    val day: Int?,
    @SerialName("month")
    val month: Int?,
    @SerialName("year")
    val year: Int?
)

@Keep
@Serializable
data class Children(
    @SerialName("age")
    val age: Int?
)

@Keep
@Serializable
data class Destination(
    @SerialName("regionId")
    val regionId: String?
)

@Keep
@Serializable
data class Filters(
    @SerialName("price")
    val price: Price?
)

@Keep
@Serializable
data class Price(
    @SerialName("max")
    val max: Int?,
    @SerialName("min")
    val min: Int?
)