package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class ActionXXXX(
    @SerializedName("accessibility")
    val accessibility: String,
    @SerializedName("actionType")
    val actionType: String,
    @SerializedName("analytics")
    val analytics: Analytics,
    @SerializedName("__typename")
    val typename: String
)