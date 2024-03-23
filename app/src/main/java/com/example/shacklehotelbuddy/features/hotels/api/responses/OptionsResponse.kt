package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

/**
 * Options response.
 *
 * @property formattedDisplayPrice Formatted display price
 * @constructor Create [OptionsResponse]
 */
data class OptionsResponse(
    @SerializedName("formattedDisplayPrice")    val formattedDisplayPrice: String
)