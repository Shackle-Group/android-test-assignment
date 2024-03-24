package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

/**
 * Price response.
 *
 * @property options [OptionsResponse]
 * @constructor Create [PriceResponse]
 */
data class PriceResponse(
    @SerializedName("options")  val options: List<OptionsResponse> = emptyList()
)