package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class LoyaltyInfo(
    @SerializedName("saveWithPointsActionMessage")
    val saveWithPointsActionMessage: Any,
    @SerializedName("saveWithPointsMessage")
    val saveWithPointsMessage: Any,
    @SerializedName("__typename")
    val typename: String
)