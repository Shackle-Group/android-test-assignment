package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class OfferBadge(
    @SerializedName("primary")
    val primary: Primary,
    @SerializedName("secondary")
    val secondary: Secondary,
    @SerializedName("__typename")
    val typename: String
)