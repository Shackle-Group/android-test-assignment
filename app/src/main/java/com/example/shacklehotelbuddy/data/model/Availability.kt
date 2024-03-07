package com.example.shacklehotelbuddy.data.model

import com.google.gson.annotations.SerializedName

data class Availability(
    @SerializedName("available")
    val available: Boolean,
    @SerializedName("minRoomsLeft")
    val minRoomsLeft: Int,
    @SerializedName("__typename")
    val typename: String
)