package com.adrianczuczka.features.properties.model

import java.util.Currency


data class PropertyListItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val dailyRate: DailyRate,
    val rating: Double,
    val imageUrl: String,
) {
    data class DailyRate(
        val rate: Int,
        val currency: Currency,
    )
}