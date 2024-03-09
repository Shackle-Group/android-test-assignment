package com.example.shacklehotelbuddy.data.remote.model

import com.google.gson.annotations.SerializedName

data class HotelSearchResponse(
    @SerializedName("data")
    val data: DataResponse
)

data class DataResponse(
    @SerializedName("propertySearch")
    val propertySearch: PropertySearch
)

data class PropertySearch(
    @SerializedName("properties")
    val properties: List<Property>
)

data class Property(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("propertyImage")
    val propertyImage: PropertyImage?,
    @SerializedName("neighborhood")
    val neighborhood: Neighborhood?,
    @SerializedName("star")
    val star: String?,
    @SerializedName("price")
    val price: PriceResponse?
)

data class PropertyImage(
    @SerializedName("image")
    val image: Image
)

data class Image(
    @SerializedName("url")
    val url: String
)

data class Neighborhood(
    @SerializedName("name")
    val name: String
)

data class Reviews(
    @SerializedName("score")
    val score: Double
)

data class PriceResponse(
    @SerializedName("lead")
    val lead: Lead
)

data class Lead(
    @SerializedName("formatted")
    val formatted: String
)