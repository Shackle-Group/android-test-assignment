package com.example.shacklehotelbuddy.data.model


import com.google.gson.annotations.SerializedName

data class FilterMetadata(
    @SerializedName("amenities")
    val amenities: List<Amenity>,
    @SerializedName("neighborhoods")
    val neighborhoods: List<Neighborhood>,
    @SerializedName("priceRange")
    val priceRange: PriceRange,
    @SerializedName("__typename")
    val typename: String
)