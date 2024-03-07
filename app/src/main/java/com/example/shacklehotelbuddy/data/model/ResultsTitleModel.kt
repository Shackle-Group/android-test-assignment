package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class ResultsTitleModel(
    @SerializedName("header")
    val header: String,
    @SerializedName("__typename")
    val typename: String
)