package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class SponsoredListing(
    @SerializedName("clickTrackingUrl")
    val clickTrackingUrl: String,
    @SerializedName("hotelImage")
    val hotelImage: String,
    @SerializedName("impressionTrackingUrl")
    val impressionTrackingUrl: String,
    @SerializedName("trackingInfo")
    val trackingInfo: TrackingInfo,
    @SerializedName("__typename")
    val typename: String
)