package com.example.shacklehotelbuddy.features.search.api.request

import com.google.gson.annotations.SerializedName

data class FiltersRequest(
    @SerializedName("price") val price: PriceRequest,
)