package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class DisplayMessage(
    @SerializedName("lineItems")
    val lineItems: List<LineItem>,
    @SerializedName("__typename")
    val typename: String
)