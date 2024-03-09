package com.example.shacklehotelbuddy.data.remote.model

import androidx.annotation.Keep
import com.example.shacklehotelbuddy.domain.model.SearchDate
import com.google.gson.annotations.SerializedName

@Keep
data class HotelSearchRequest(
    @SerializedName("rooms")
    val rooms: List<Room>,
    @SerializedName("checkInDate")
    val checkInDate: SearchDate,
    @SerializedName("checkOutDate")
    val checkOutDate: SearchDate,
    @SerializedName("currency")
    val currency: String = "USD",
    @SerializedName("locale")
    val locale: String = "en_US",
    @SerializedName("eapid")
    val eapid: Int = 1,
    @SerializedName("siteId")
    val siteId: Int = 300000001,
    @SerializedName("destination")
    val destination: DestinationEntity = DestinationEntity(),
    @SerializedName("resultsStartingIndex")
    val resultsStartingIndex: Int = 0,
    @SerializedName("resultsSize")
    val resultsSize: Int = 20,
    @SerializedName("sort")
    val sort: String = "PRICE_LOW_TO_HIGH",
    @SerializedName("filters")
    val filters: Filter = Filter()
)

data class Room(
    @SerializedName("adults")
    val adults: Int,
    @SerializedName("children")
    val children: List<Child>
)

data class Child(
    @SerializedName("age")
    val age: Int = 7
)

data class DestinationEntity(
    @SerializedName("regionId")
    val regionId: String = "6054439"
)

data class Filter(
    @SerializedName("price")
    val price: Price = Price()
)

data class Price(
    @SerializedName("max")
    val max: Int = 150,
    @SerializedName("min")
    val min: Int = 100
)
