package com.example.shacklehotelbuddy.data.model

import com.google.gson.annotations.SerializedName

data class HotelRequest(
    @SerializedName("checkInDate")
    var checkInDate: CheckInDateX,
    @SerializedName("checkOutDate")
    var checkOutDate: CheckOutDateX,
    @SerializedName("currency")
    var currency: String? = null,
    @SerializedName("destination")
    var destination: Destination,
    @SerializedName("eapid")
    var eapid: Int?= null,
    @SerializedName("resultsSize")
    var resultsSize: Int,
    @SerializedName("resultsStartingIndex")
    var resultsStartingIndex: Int,
    @SerializedName("rooms")
    var rooms: List<Room>,
    @SerializedName("siteId")
    var siteId: Int? = null
)