package com.adrianczuczka.data.properties.search

import androidx.room.TypeConverter
import com.adrianczuczka.data.properties.search.model.DbDateInfo
import com.google.gson.Gson

class Converters {

    @TypeConverter
    fun fromDateInfo(dbDateInfo: DbDateInfo): String = Gson().toJson(dbDateInfo)

    @TypeConverter
    fun toDateInfo(json: String): DbDateInfo = Gson().fromJson(json, DbDateInfo::class.java)
}