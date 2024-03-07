package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Selected(
    @SerializedName("id")
    val id: String,
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int,
    @SerializedName("__typename")
    val typename: String
)