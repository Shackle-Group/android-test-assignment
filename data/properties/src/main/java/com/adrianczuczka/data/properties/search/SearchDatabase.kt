package com.adrianczuczka.data.properties.search

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adrianczuczka.data.properties.search.model.DbSearchInfo

@Database(entities = [DbSearchInfo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SearchDatabase : RoomDatabase() {
    abstract fun searchDao(): SearchDao
}