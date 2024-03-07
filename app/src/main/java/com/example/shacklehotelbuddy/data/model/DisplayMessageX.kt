package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class DisplayMessageX(
    @SerializedName("lineItems")
    val lineItems: List<LineItemX>,
    @SerializedName("__typename")
    val typename: String
)