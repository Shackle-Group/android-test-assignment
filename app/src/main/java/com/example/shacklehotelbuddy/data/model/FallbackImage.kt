package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class FallbackImage(
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("url")
    val url: String
)