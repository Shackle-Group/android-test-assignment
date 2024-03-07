package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class DistanceFromDestination(
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("value")
    val value: Double
)