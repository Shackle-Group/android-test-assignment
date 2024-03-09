package com.example.shacklehotelbuddy.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HotelSearchEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val checkInDate: String,
    val checkOutDate: String,
    val adults: Int,
    val children: Int
)