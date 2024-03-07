package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PriceMetadataX(
    @SerializedName("discountType")
    val discountType: String,
    @SerializedName("totalDiscountPercentage")
    val totalDiscountPercentage: Int,
    @SerializedName("__typename")
    val typename: String
)