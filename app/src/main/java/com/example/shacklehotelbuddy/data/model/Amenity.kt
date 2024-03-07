package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Amenity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("__typename")
    val typename: String
)