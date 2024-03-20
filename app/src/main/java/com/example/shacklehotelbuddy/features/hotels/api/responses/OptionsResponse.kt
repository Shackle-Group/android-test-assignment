package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

data class OptionsResponse(
    @SerializedName("formattedDisplayPrice")    val formattedDisplayPrice: String?
)