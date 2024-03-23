package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

/**
 * Data response.
 *
 * @property propertySearch [PropertySearchResponse]
 * @constructor Create [DataResponse]
 */
data class DataResponse(
    @SerializedName("propertySearch")   val propertySearch: PropertySearchResponse?
)