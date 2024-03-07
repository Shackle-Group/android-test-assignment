package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class SortSection(
    @SerializedName("fields")
    val fields: List<FieldX>,
    @SerializedName("title")
    val title: Any,
    @SerializedName("__typename")
    val typename: String
)