package com.example.shacklehotelbuddy.data.model

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("checkInDate")
    val checkInDate: CheckInDate,
    @SerializedName("checkoutDate")
    val checkoutDate: CheckoutDate,
    @SerializedName("regionId")
    val regionId: String,
    @SerializedName("roomConfiguration")
    val roomConfiguration: List<RoomConfiguration>,
    @SerializedName("__typename")
    val typename: String
)