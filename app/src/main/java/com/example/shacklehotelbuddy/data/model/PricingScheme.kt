package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PricingScheme(
    @SerializedName("type")
    val type: String,
    @SerializedName("__typename")
    val typename: String
)