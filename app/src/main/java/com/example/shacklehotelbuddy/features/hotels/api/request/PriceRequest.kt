package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

/**
 * Price request.
 *
 * @property max Max price
 * @property min Min price
 * @constructor Create [PriceRequest]
 */
data class PriceRequest(
    @SerializedName("max")       val max: Long,
    @SerializedName("min")       val min: Long
)