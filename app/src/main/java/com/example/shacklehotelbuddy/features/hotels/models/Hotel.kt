package com.example.shacklehotelbuddy.features.hotels.models

/**
 * Hotel.
 *
 * @property id Unique identifier
 * @property name Hotel name
 * @property url Preview URL
 * @property price Price
 * @property location Location
 * @property rating Rating
 * @constructor Create [Hotel]
 */
data class Hotel(
    val id: String,
    val name: String,
    val url: String,
    val price: String?,
    val location: String,
    val rating: String
)