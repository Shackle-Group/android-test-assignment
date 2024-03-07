package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PriceAfterLoyaltyPointsApplied(
    @SerializedName("lead")
    val lead: LeadX,
    @SerializedName("options")
    val options: List<OptionX>,
    @SerializedName("__typename")
    val typename: String
)