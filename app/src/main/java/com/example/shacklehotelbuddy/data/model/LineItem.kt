package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class LineItem(
    @SerializedName("accessibilityLabel")
    val accessibilityLabel: Any,
    @SerializedName("badge")
    val badge: Any,
    @SerializedName("disclaimer")
    val disclaimer: Disclaimer,
    @SerializedName("mark")
    val mark: Any,
    @SerializedName("price")
    val price: PriceX,
    @SerializedName("role")
    val role: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("value")
    val value: String
)