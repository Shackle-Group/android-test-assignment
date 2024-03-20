package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

data class PriceRequest(
    @SerializedName("max")       val max: Long,
    @SerializedName("min")       val min: Long
)