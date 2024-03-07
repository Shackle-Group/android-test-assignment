package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Neighborhood(
    @SerializedName("name")
    val name: String,
    @SerializedName("regionId")
    val regionId: String,
    @SerializedName("__typename")
    val typename: String
)