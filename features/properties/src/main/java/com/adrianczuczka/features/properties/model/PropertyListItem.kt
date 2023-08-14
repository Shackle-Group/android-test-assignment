package com.adrianczuczka.features.properties.model


data class PropertyListItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val dailyRate: String,
    val rating: Double,
    val imageUrl: String,
)