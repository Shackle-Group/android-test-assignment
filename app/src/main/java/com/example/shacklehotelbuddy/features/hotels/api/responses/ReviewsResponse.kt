package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

/**
 * Reviews response.
 *
 * @property score Review score
 * @property total Total reviews
 * @constructor Create [ReviewsResponse]
 */
data class ReviewsResponse(
    @SerializedName("score") val score: String,
    @SerializedName("total") val total: String
)