package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class SponsoredListingX(
    @SerializedName("clickTrackingUrl")
    val clickTrackingUrl: String,
    @SerializedName("hotelImage")
    val hotelImage: String,
    @SerializedName("impressionTrackingUrl")
    val impressionTrackingUrl: String,
    @SerializedName("__typename")
    val typename: String
)