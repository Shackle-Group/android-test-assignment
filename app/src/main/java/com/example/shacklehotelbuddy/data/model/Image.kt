package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("description")
    val description: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("url")
    val url: String
)