package com.example.shacklehotelbuddy.features.search.api.request

import com.google.gson.annotations.SerializedName

data class ChildRequest(
    @SerializedName("age")      val age: Long,
)