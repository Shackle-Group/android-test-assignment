package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("displayMessages")
    val displayMessages: List<DisplayMessage>,
    @SerializedName("lead")
    val lead: Lead,
    @SerializedName("options")
    val options: List<Option>,
    @SerializedName("priceMessages")
    val priceMessages: List<PriceMessage>,
    @SerializedName("priceMessaging")
    val priceMessaging: Any,
    @SerializedName("strikeOut")
    val strikeOut: StrikeOutX,
    @SerializedName("strikeOutType")
    val strikeOutType: String,
    @SerializedName("__typename")
    val typename: String
)