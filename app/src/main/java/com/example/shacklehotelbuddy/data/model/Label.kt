package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Label(
    @SerializedName("label")
    val label: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("value")
    val value: Int
)