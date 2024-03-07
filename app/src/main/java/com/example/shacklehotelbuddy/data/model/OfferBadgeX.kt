package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class OfferBadgeX(
    @SerializedName("secondary")
    val secondary: SecondaryX,
    @SerializedName("__typename")
    val typename: String
)