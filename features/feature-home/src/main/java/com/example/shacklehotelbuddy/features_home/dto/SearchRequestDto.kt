package com.example.shacklehotelbuddy.features_home.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import android.support.annotation.Keep

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