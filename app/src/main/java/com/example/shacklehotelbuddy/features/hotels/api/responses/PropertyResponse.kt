package com.example.shacklehotelbuddy.features.hotels.api.responses

import com.google.gson.annotations.SerializedName

/**
 * Property response.
 *
 * @property id Property ID
 * @property name Property name
 * @property propertyImage [PropertyImageResponse]
 * @property neighborhood [NeighborhoodResponse]
 * @property star Property star rating
 * @property price [PriceResponse]
 * @property reviews [ReviewsResponse]
 * @constructor Create [PropertyResponse]
 */
class PropertyResponse(
    @SerializedName("id")                   val id: String,
    @SerializedName("name")                 val name: String,
    @SerializedName("propertyImage")        val propertyImage: PropertyImageResponse,
    @SerializedName("neighborhood")         val neighborhood: NeighborhoodResponse,
    @SerializedName("star")                 val star: String,
    @SerializedName("price")                val price: PriceResponse,
    @SerializedName("reviews")              val reviews: ReviewsResponse
)