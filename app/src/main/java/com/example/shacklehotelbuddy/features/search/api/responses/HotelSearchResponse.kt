package com.example.shacklehotelbuddy.features.search.api.responses

import com.google.gson.annotations.SerializedName

data class HotelSearchResponse(
    @SerializedName("data") val data: DataResponse?
)