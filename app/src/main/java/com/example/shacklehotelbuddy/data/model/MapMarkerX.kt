package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class MapMarkerX(
    @SerializedName("label")
    val label: String,
    @SerializedName("__typename")
    val typename: String
)