package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PriceMessage(
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("value")
    val value: String
)