package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class ResultsSummary(
    @SerializedName("accessibilityLabel")
    val accessibilityLabel: String,
    @SerializedName("link")
    val link: Link,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("value")
    val value: String
)