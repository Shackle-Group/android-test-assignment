package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Lead(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currencyInfo")
    val currencyInfo: CurrencyInfo,
    @SerializedName("formatted")
    val formatted: String,
    @SerializedName("__typename")
    val typename: String
)