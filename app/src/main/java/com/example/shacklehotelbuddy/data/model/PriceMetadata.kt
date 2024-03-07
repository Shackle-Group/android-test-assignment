package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PriceMetadata(
    @SerializedName("discountType")
    val discountType: String,
    @SerializedName("rateDiscount")
    val rateDiscount: RateDiscount,
    @SerializedName("totalDiscountPercentage")
    val totalDiscountPercentage: Int,
    @SerializedName("__typename")
    val typename: String
)