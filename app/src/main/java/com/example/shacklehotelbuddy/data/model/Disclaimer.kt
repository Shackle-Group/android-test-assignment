package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Disclaimer(
    @SerializedName("content")
    val content: List<String>,
    @SerializedName("title")
    val title: Any,
    @SerializedName("__typename")
    val typename: String
)