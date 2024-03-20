package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

data class NeighborhoodResponse(
    @SerializedName("name") val name: String?
)