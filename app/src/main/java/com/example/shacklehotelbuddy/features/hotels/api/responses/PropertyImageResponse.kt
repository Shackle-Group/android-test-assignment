package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

/**
 * Property image response.
 *
 * @property image [ImageResponse]
 * @constructor Create [PropertyImageResponse]
 */
data class PropertyImageResponse(
    @SerializedName("image")        val image: ImageResponse
)