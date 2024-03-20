package com.example.shacklehotelbuddy.features.search.api.responses

import com.google.gson.annotations.SerializedName

data class PriceResponse(
    @SerializedName("options")  val options: List<OptionsResponse>? = emptyList()
)