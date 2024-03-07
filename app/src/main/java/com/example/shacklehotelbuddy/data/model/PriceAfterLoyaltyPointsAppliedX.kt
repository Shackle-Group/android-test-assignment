package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PriceAfterLoyaltyPointsAppliedX(
    @SerializedName("lead")
    val lead: LeadXXX,
    @SerializedName("options")
    val options: List<OptionXXX>,
    @SerializedName("__typename")
    val typename: String
)