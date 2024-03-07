package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class DestinationInfo(
    @SerializedName("distanceFromDestination")
    val distanceFromDestination: DistanceFromDestination,
    @SerializedName("distanceFromMessaging")
    val distanceFromMessaging: Any,
    @SerializedName("regionId")
    val regionId: String,
    @SerializedName("__typename")
    val typename: String
)