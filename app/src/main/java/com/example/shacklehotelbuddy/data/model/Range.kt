package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Range(
    @SerializedName("analytics")
    val analytics: Analytics,
    @SerializedName("characteristics")
    val characteristics: Characteristics,
    @SerializedName("icon")
    val icon: Any,
    @SerializedName("id")
    val id: String,
    @SerializedName("primary")
    val primary: String,
    @SerializedName("secondary")
    val secondary: Any,
    @SerializedName("selected")
    val selected: Selected,
    @SerializedName("__typename")
    val typename: String
)