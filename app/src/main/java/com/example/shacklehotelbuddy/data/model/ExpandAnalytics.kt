package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class ExpandAnalytics(
    @SerializedName("linkName")
    val linkName: String,
    @SerializedName("referrerId")
    val referrerId: String,
    @SerializedName("__typename")
    val typename: String
)