package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class RevealAction(
    @SerializedName("accessibility")
    val accessibility: String,
    @SerializedName("action")
    val action: Action,
    @SerializedName("badge")
    val badge: Int,
    @SerializedName("disabled")
    val disabled: Boolean,
    @SerializedName("primary")
    val primary: String,
    @SerializedName("__typename")
    val typename: String
)