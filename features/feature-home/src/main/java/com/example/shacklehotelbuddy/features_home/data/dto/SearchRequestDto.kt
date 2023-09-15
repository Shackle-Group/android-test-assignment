package com.example.shacklehotelbuddy.features_home.data.dto


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchRequestDto(
    @SerializedName("checkInDate")
    val checkInDate: CheckInDate?,
    @SerializedName("checkOutDate")
    val checkOutDate: CheckOutDate?,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("destination")
    val destination: Destination?,
    @SerializedName("eapid")
    val eapid: Int?,
    @SerializedName("locale")
    val locale: String?,
    @SerializedName("resultsSize")
    val resultsSize: Int?,
    @SerializedName("resultsStartingIndex")
    val resultsStartingIndex: Int?,
    @SerializedName("rooms")
    val rooms: List<Room?>?,
    @SerializedName("siteId")
    val siteId: Int?,
    @SerializedName("sort")
    val sort: String?
)

@Keep
@Serializable
data class Room(
    @SerializedName("adults")
    val adults: Int?,
    @SerializedName("children")
    val children: List<Children?>?
)

@Keep
@Serializable
data class CheckInDate(
    @SerializedName("day")
    val day: Int?,
    @SerializedName("month")
    val month: Int?,
    @SerializedName("year")
    val year: Int?
)


@Keep
@Serializable
data class CheckOutDate(
    @SerializedName("day")
    val day: Int?,
    @SerializedName("month")
    val month: Int?,
    @SerializedName("year")
    val year: Int?
)

@Keep
@Serializable
data class Children(
    @SerializedName("age")
    val age: Int?
)

@Keep
@Serializable
data class Destination(
    @SerializedName("regionId")
    val regionId: String?
)

@Keep
@Serializable
data class Filters(
    @SerializedName("price")
    val price: Price?
)
