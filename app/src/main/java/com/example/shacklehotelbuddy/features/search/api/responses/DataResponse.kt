package com.example.shacklehotelbuddy.features.search.api.responses

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("propertySearch")   val propertySearch: PropertySearchResponse?
)