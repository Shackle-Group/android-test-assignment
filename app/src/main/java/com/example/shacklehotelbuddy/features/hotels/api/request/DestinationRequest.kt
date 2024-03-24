package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

/**
 * Destination request.
 *
 * @property regionId Region id
 * @constructor Create [DestinationRequest]
 */
data class DestinationRequest (
    @SerializedName("regionId")     val regionId: String
)
