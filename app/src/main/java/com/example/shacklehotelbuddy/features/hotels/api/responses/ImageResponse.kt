package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

/**
 * Image response.
 *
 * @property url Image URL
 * @property description Image description
 * @constructor Create [ImageResponse]
 */
data class ImageResponse(
    @SerializedName("url")              val url: String,
    @SerializedName("description")      val description: String
)