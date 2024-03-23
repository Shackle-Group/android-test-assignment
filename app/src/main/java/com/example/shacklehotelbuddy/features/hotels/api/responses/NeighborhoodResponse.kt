package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

/**
 * Neighborhood response.
 *
 * @property name Neighborhood name
 * @constructor Create [NeighborhoodResponse]
 */
data class NeighborhoodResponse(
    @SerializedName("name") val name: String
)