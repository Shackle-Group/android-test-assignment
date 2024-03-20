package com.example.shacklehotelbuddy.features.search.api.responses

import com.google.gson.annotations.SerializedName

data class ReviewsResponse(
    @SerializedName("score") val score: String?,
    @SerializedName("total") val total: String?
)