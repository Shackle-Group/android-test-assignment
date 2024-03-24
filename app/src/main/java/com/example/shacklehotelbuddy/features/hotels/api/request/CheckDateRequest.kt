package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

/**
 * Check date request.
 *
 * @property day Day
 * @property month Month
 * @property year Year
 * @constructor Create [CheckDateRequest]
 */
data class CheckDateRequest(
    @SerializedName("day")          val day: Long,
    @SerializedName("month")        val month: Long,
    @SerializedName("year")         val year: Long
)