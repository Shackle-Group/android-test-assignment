package com.example.shacklehotelbuddy.features.search.api.request

import com.google.gson.annotations.SerializedName

data class RoomRequest(
    @SerializedName("adults")           val adults: Long,
    @SerializedName("children")         val children: List<ChildRequest>
)