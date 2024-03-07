package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PrimaryXX(
    @SerializedName("action")
    val action: Action,
    @SerializedName("primary")
    val primary: Any,
    @SerializedName("__typename")
    val typename: String
)