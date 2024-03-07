package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class MultiSelectionOption(
    @SerializedName("analytics")
    val analytics: Analytics,
    @SerializedName("default")
    val default: Boolean,
    @SerializedName("description")
    val description: String,
    @SerializedName("deselectAnalytics")
    val deselectAnalytics: DeselectAnalytics,
    @SerializedName("disabled")
    val disabled: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("primary")
    val primary: String,
    @SerializedName("secondary")
    val secondary: Any,
    @SerializedName("selectAnalytics")
    val selectAnalytics: SelectAnalytics,
    @SerializedName("selected")
    val selected: Boolean,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("value")
    val value: String
)