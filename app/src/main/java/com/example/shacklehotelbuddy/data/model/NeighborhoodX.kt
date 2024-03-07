package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class NeighborhoodX(
    @SerializedName("name")
    val name: String,
    @SerializedName("__typename")
    val typename: String
)