package com.adrianczuczka.data.properties.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.adrianczuczka.data.properties.local.model.DbProperty
import com.adrianczuczka.data.properties.local.model.DbPropertySearch
import com.adrianczuczka.data.properties.local.remotekey.RemoteKey
import com.adrianczuczka.data.properties.local.remotekey.RemoteKeyDao

@Database(
    entities = [DbProperty::class, DbPropertySearch::class, RemoteKey::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class PropertiesDatabase : RoomDatabase() {
    abstract fun propertiesDao(): PropertiesDao

    abstract fun remoteKeyDao(): RemoteKeyDao
}