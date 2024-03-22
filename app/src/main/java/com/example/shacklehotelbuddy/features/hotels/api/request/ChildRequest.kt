package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

/**
 * Child request.
 *
 * @property age Child age
 * @constructor Create [ChildRequest]
 */
data class ChildRequest(
    @SerializedName("age")      val age: Long,
)