package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

/**
 * Property search response.
 *
 * @property properties List of [PropertyResponse]
 * @constructor Create [PropertySearchResponse]
 */
data class PropertySearchResponse(
    @SerializedName("properties")       val properties: List<PropertyResponse> = emptyList()
)