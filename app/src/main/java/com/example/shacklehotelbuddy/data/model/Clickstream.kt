package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class Clickstream(
    @SerializedName("searchResultsViewed")
    val searchResultsViewed: Any,
    @SerializedName("__typename")
    val typename: String
)