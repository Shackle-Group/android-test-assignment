package com.example.shacklehotelbuddy.features.search.api.responses

import com.google.gson.annotations.SerializedName

data class PropertyImageResponse(
    @SerializedName("image")        val image: ImageResponse?
)