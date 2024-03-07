package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class LineItemX(
    @SerializedName("accessibilityLabel")
    val accessibilityLabel: Any,
    @SerializedName("badge")
    val badge: Any,
    @SerializedName("mark")
    val mark: Any,
    @SerializedName("role")
    val role: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("value")
    val value: String
)