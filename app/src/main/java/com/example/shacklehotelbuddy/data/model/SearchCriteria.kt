package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class SearchCriteria(
    @SerializedName("resolvedDateRange")
    val resolvedDateRange: ResolvedDateRange,
    @SerializedName("__typename")
    val typename: String
)