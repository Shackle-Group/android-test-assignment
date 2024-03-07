package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PriceXX(
    @SerializedName("displayMessages")
    val displayMessages: List<DisplayMessageX>,
    @SerializedName("lead")
    val lead: LeadXX,
    @SerializedName("options")
    val options: List<OptionXX>,
    @SerializedName("priceMessaging")
    val priceMessaging: Any,
    @SerializedName("strikeOut")
    val strikeOut: StrikeOutXXXX,
    @SerializedName("strikeOutType")
    val strikeOutType: String,
    @SerializedName("__typename")
    val typename: String
)