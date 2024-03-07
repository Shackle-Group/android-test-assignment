package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class LeadXXX(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("formatted")
    val formatted: String,
    @SerializedName("__typename")
    val typename: String
)