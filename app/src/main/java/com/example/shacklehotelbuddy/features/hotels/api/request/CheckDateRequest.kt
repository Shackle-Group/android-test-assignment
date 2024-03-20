package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

data class CheckDateRequest(
    @SerializedName("day")          val day: Long,
    @SerializedName("month")        val month: Long,
    @SerializedName("year")         val year: Long
)