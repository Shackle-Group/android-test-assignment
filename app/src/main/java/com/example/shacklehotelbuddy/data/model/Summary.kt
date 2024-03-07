package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Summary(
    @SerializedName("loyaltyInfo")
    val loyaltyInfo: LoyaltyInfo,
    @SerializedName("matchedPropertiesSize")
    val matchedPropertiesSize: Int,
    @SerializedName("pricingScheme")
    val pricingScheme: PricingScheme,
    @SerializedName("regionCompression")
    val regionCompression: Any,
    @SerializedName("resultsSummary")
    val resultsSummary: List<ResultsSummary>,
    @SerializedName("resultsTitleModel")
    val resultsTitleModel: ResultsTitleModel,
    @SerializedName("__typename")
    val typename: String
)