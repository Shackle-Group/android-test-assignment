package com.example.shacklehotelbuddy.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shacklehotelbuddy.core_database.converters.DateTypeConverter
import com.example.shacklehotelbuddy.core_database.dao.SearchQueryDao
import com.example.shacklehotelbuddy.core_database.entities.SearchQueryEntity

@Database(
    exportSchema = false,
    version = 1,
    entities = [SearchQueryEntity::class]
)
@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun provideSearchQueryDao(): SearchQueryDao
}