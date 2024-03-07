package com.example.shacklehotelbuddy.data.model

import com.google.gson.annotations.SerializedName

data class CheckInDate(
    @SerializedName("day")
    val day: Int,
    @SerializedName("month")
    val month: Int,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("year")
    val year: Int
)