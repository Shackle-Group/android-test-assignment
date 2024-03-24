package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

/**
 * Hotel search response.
 *
 * @property data [DataResponse]
 * @constructor Create [HotelSearchResponse]
 */
data class HotelSearchResponse(
    @SerializedName("data") val data: DataResponse?
)