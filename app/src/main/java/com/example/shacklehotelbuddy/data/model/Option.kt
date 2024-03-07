package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Option(
    @SerializedName("disclaimer")
    val disclaimer: DisclaimerX,
    @SerializedName("formattedDisplayPrice")
    val formattedDisplayPrice: String,
    @SerializedName("strikeOut")
    val strikeOut: StrikeOut,
    @SerializedName("__typename")
    val typename: String
)