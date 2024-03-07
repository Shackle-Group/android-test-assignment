package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class TypeaheadInfo(
    @SerializedName("client")
    val client: String,
    @SerializedName("isDestination")
    val isDestination: Boolean,
    @SerializedName("lineOfBusiness")
    val lineOfBusiness: String,
    @SerializedName("maxNumberOfResults")
    val maxNumberOfResults: Int,
    @SerializedName("packageType")
    val packageType: Any,
    @SerializedName("personalize")
    val personalize: Boolean,
    @SerializedName("regionType")
    val regionType: Int,
    @SerializedName("typeaheadFeatures")
    val typeaheadFeatures: String,
    @SerializedName("__typename")
    val typename: String
)