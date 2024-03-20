package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @SerializedName("url")              val url: String?,
    @SerializedName("description")      val description: String?
)