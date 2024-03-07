package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class OptionXXX(
    @SerializedName("formattedDisplayPrice")
    val formattedDisplayPrice: String,
    @SerializedName("__typename")
    val typename: String
)