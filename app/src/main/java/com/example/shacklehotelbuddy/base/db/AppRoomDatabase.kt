package com.example.shacklehotelbuddy.base.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shacklehotelbuddy.features.search.db.SearchParametersEntity
import com.example.shacklehotelbuddy.features.search.db.SearchParametersDao

private const val DATABASE_VERSION = 1

@Database(
    entities = [
        SearchParametersEntity::class,
    ],
    version = DATABASE_VERSION,
    exportSchema = true
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchParametersDao
}