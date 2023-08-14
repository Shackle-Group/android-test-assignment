package com.adrianczuczka.data.properties.remote.model

data class ApiProperty(
    val id: String,
    val name: String,
    val neighborhood: Neighborhood,
    val price: Price,
    val reviews: Reviews,
    val propertyImage: PropertyImage,
) {
    data class Price(
        val lead: Lead,
    ) {
        data class Lead(
            val formatted: String,
        )
    }

    data class Neighborhood(
        val name: String,
    )

    data class Reviews(
        val score: Double,
    )

    data class PropertyImage(
        val image: Image,
    ) {
        data class Image(
            val url: String,
        )
    }
}