package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Room(
    @SerializedName("adults")
    val adults: Int,
    @SerializedName("children")
    val children: List<Children>
)