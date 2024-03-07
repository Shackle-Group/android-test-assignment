package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class LatLong(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("__typename")
    val typename: String
)