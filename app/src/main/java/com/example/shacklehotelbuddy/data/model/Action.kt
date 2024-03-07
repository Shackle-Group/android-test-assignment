package com.example.shacklehotelbuddy.data.model

import com.google.gson.annotations.SerializedName

data class Action(
    @SerializedName("accessibility")
    val accessibility: Any,
    @SerializedName("actionType")
    val actionType: String,
    @SerializedName("analytics")
    val analytics: Analytics,
    @SerializedName("__typename")
    val typename: String
)