package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class ApplyAction(
    @SerializedName("accessibility")
    val accessibility: String,
    @SerializedName("action")
    val action: Action,
    @SerializedName("badge")
    val badge: Any,
    @SerializedName("disabled")
    val disabled: Boolean,
    @SerializedName("icon")
    val icon: Any,
    @SerializedName("primary")
    val primary: String,
    @SerializedName("__typename")
    val typename: String
)