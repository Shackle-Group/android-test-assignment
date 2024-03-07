package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Icon(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("size")
    val size: Any,
    @SerializedName("theme")
    val theme: Any,
    @SerializedName("token")
    val token: String,
    @SerializedName("__typename")
    val typename: String
)