package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Characteristics(
    @SerializedName("labels")
    val labels: List<Label>,
    @SerializedName("max")
    val max: Int,
    @SerializedName("min")
    val min: Int,
    @SerializedName("step")
    val step: Int,
    @SerializedName("__typename")
    val typename: String
)