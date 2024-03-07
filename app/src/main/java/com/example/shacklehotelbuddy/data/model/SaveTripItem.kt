package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class SaveTripItem(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("initialChecked")
    val initialChecked: Boolean,
    @SerializedName("itemId")
    val itemId: String,
    @SerializedName("remove")
    val remove: Remove,
    @SerializedName("save")
    val save: Save,
    @SerializedName("source")
    val source: String,
    @SerializedName("__typename")
    val typename: String
)