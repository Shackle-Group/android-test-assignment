package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PriceRange(
    @SerializedName("max")
    val max: Double,
    @SerializedName("min")
    val min: Double,
    @SerializedName("__typename")
    val typename: String
)