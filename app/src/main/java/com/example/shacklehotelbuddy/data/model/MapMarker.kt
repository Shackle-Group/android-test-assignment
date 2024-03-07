package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class MapMarker(
    @SerializedName("label")
    val label: String,
    @SerializedName("latLong")
    val latLong: LatLong,
    @SerializedName("__typename")
    val typename: String
)