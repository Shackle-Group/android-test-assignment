package com.example.shacklehotelbuddy.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shacklehotelbuddy.data.local.model.HotelSearchEntity

@Database(entities = [HotelSearchEntity::class], version = 1)
abstract class HotelSearchDatabase : RoomDatabase() {
    abstract fun hotelSearchDao(): HotelSearchDao
}