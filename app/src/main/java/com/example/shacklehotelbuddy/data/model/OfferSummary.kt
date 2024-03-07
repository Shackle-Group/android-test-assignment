package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class OfferSummary(
    @SerializedName("attributes")
    val attributes: List<Attribute>,
    @SerializedName("messages")
    val messages: List<Message>,
    @SerializedName("__typename")
    val typename: String
)