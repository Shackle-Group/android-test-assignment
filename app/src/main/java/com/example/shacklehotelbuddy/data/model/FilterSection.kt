package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class FilterSection(
    @SerializedName("fields")
    val fields: List<Field>,
    @SerializedName("title")
    val title: String,
    @SerializedName("__typename")
    val typename: String
)