package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("propertySearch")
    val propertySearch: PropertySearch
)