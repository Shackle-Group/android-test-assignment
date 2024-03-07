package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class OptionXX(
    @SerializedName("formattedDisplayPrice")
    val formattedDisplayPrice: String,
    @SerializedName("__typename")
    val typename: String
)