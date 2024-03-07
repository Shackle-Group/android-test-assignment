package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PropertyImage(
    @SerializedName("alt")
    val alt: String,
    @SerializedName("fallbackImage")
    val fallbackImage: FallbackImage,
    @SerializedName("image")
    val image: Image,
    @SerializedName("subjectId")
    val subjectId: Int,
    @SerializedName("__typename")
    val typename: String
)