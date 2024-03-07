package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Map(
    @SerializedName("subtitle")
    val subtitle: Any,
    @SerializedName("__typename")
    val typename: String
)