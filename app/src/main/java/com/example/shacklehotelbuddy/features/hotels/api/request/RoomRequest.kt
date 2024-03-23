package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

/**
 * Room request.
 *
 * @property adults Number of adults
 * @property children List of [ChildRequest]
 * @constructor Create [RoomRequest]
 */
data class RoomRequest(
    @SerializedName("adults")           val adults: Long,
    @SerializedName("children")         val children: List<ChildRequest>
)