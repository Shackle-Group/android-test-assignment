package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("clientSideAnalytics")
    val clientSideAnalytics: ClientSideAnalytics,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("uri")
    val uri: Uri
)