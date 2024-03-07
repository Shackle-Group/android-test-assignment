package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class PropertySearch(
    @SerializedName("clickstream")
    val clickstream: Clickstream,
    @SerializedName("filterMetadata")
    val filterMetadata: FilterMetadata,
    @SerializedName("map")
    val map: Map,
    @SerializedName("properties")
    val properties: List<Property>,
    @SerializedName("propertySearchListings")
    val propertySearchListings: List<PropertySearchListings>,
    @SerializedName("searchCriteria")
    val searchCriteria: SearchCriteria,
    @SerializedName("shoppingContext")
    val shoppingContext: ShoppingContext,
    @SerializedName("summary")
    val summary: Summary,
    @SerializedName("__typename")
    val typename: String,
    @SerializedName("universalSortAndFilter")
    val universalSortAndFilter: UniversalSortAndFilter
)