package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Remove(
    @SerializedName("accessibility")
    val accessibility: String,
    @SerializedName("analytics")
    val analytics: Analytics,
    @SerializedName("__typename")
    val typename: String
)