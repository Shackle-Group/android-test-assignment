package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class TrackingInfo(
    @SerializedName("beaconIssued")
    val beaconIssued: String,
    @SerializedName("candidateHmGuid")
    val candidateHmGuid: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("slots")
    val slots: String,
    @SerializedName("testVersionOverride")
    val testVersionOverride: String,
    @SerializedName("trackingData")
    val trackingData: String,
    @SerializedName("__typename")
    val typename: String
)