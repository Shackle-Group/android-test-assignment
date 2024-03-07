package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Expando(
    @SerializedName("collapseAnalytics")
    val collapseAnalytics: CollapseAnalytics,
    @SerializedName("collapseLabel")
    val collapseLabel: String,
    @SerializedName("expandAnalytics")
    val expandAnalytics: ExpandAnalytics,
    @SerializedName("expandLabel")
    val expandLabel: String,
    @SerializedName("threshold")
    val threshold: Int,
    @SerializedName("__typename")
    val typename: String
)