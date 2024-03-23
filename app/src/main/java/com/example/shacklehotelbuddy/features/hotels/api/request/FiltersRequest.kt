package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

/**
 * Filters request.
 *
 * @property price [PriceRequest]
 * @constructor Create [FiltersRequest]
 */
data class FiltersRequest(
    @SerializedName("price") val price: PriceRequest,
)