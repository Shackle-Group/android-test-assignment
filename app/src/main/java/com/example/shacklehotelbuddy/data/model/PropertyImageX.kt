package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PropertyImageX(
    @SerializedName("alt")
    val alt: String,
    @SerializedName("subjectId")
    val subjectId: Int,
    @SerializedName("__typename")
    val typename: String
)