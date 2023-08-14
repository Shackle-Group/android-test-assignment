package com.adrianczuczka.data.properties.search.model

import androidx.room.Entity

@Entity(
    "searches",
    primaryKeys = ["regionId", "checkInDate", "checkOutDate", "adultCount", "childrenCount"]
)
data class DbSearchInfo(
    val regionId: String = "6200211", // Hardcoded region id
    val checkInDate: DbDateInfo,
    val checkOutDate: DbDateInfo,
    val adultCount: Int,
    val childrenCount: Int,
    val timestamp: Long,
)