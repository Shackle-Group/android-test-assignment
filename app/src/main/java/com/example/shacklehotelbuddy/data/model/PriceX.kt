package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PriceX(
    @SerializedName("accessibilityLabel")
    val accessibilityLabel: String,
    @SerializedName("formatted")
    val formatted: String,
    @SerializedName("__typename")
    val typename: String
)