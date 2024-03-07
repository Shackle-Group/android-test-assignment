package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class CurrencyInfo(
    @SerializedName("code")
    val code: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("__typename")
    val typename: String
)