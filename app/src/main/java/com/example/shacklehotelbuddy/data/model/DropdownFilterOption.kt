package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class DropdownFilterOption(
    @SerializedName("analytics")
    val analytics: Analytics,
    @SerializedName("default")
    val default: Boolean,
    @SerializedName("description")
    val description: Any,
    @SerializedName("disabled")
    val disabled: Boolean,
    @SerializedName("icon")
    val icon: Any,
    @SerializedName("id")
    val id: String,
    @SerializedName("primary")
    val primary: String,
    @SerializedName("secondary")
    val secondary: Any,
    @SerializedName("selected")
    val selected: Boolean,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("value")
    val value: String
)