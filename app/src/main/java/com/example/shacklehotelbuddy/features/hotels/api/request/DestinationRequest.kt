package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

data class DestinationRequest (
    @SerializedName("regionId")     val regionId: String
)
