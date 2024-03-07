package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class SaveTripItemX(
    @SerializedName("attributes")
    val attributes: AttributesX,
    @SerializedName("initialChecked")
    val initialChecked: Boolean,
    @SerializedName("itemId")
    val itemId: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("__typename")
    val typename: String
)