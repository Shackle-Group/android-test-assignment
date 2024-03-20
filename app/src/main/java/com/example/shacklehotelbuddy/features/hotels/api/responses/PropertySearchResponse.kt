package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

data class PropertySearchResponse(
    @SerializedName("properties")       val properties: List<PropertyResponse> = emptyList()
)