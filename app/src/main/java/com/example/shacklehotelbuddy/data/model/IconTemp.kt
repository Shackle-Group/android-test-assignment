package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class IconTemp(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("__typename")
    val typename: String
)