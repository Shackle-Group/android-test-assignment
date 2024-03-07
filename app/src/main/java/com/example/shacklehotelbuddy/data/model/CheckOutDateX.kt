package com.example.shacklehotelbuddy.data.model

import com.google.gson.annotations.SerializedName

data class CheckOutDateX(
    @SerializedName("day")
    val day: Int,
    @SerializedName("month")
    val month: Int,
    @SerializedName("year")
    val year: Int
)