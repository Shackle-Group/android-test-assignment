package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class RoomConfiguration(
    @SerializedName("childAges")
    val childAges: List<Int>,
    @SerializedName("numberOfAdults")
    val numberOfAdults: Int,
    @SerializedName("__typename")
    val typename: String
)