package com.adrianczuczka.data.properties.local

import androidx.room.TypeConverter
import com.adrianczuczka.data.properties.local.model.DbSearchInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {
    @TypeConverter
    fun fromStringList(list: List<String>): String = Gson().toJson(list)

    @TypeConverter
    fun toStringList(json: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    fun fromSearchInfo(searchInfo: DbSearchInfo): String = Gson().toJson(searchInfo)

    @TypeConverter
    fun toSearchInfo(json: String): DbSearchInfo = Gson().fromJson(json, DbSearchInfo::class.java)
}