package com.example.shacklehotelbuddy.domain.model.hotelsearch

data class HotelSearch(
    val checkInDate: SearchDate,
    val checkOutDate: SearchDate,
    val adults: Int,
    val children: Int
)