package com.adrianczuczka.data.properties.local.model

data class DbSearchInfo(
    val regionId: String,
    val checkInDate: DbDateInfo,
    val checkOutDate: DbDateInfo,
    val adultsCount: Int,
    val childrenCount: Int,
)