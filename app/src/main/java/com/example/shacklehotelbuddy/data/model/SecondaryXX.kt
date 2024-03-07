package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class SecondaryXX(
    @SerializedName("action")
    val action: ActionXXXX,
    @SerializedName("disabled")
    val disabled: Boolean,
    @SerializedName("primary")
    val primary: String,
    @SerializedName("__typename")
    val typename: String
)