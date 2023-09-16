package com.example.shacklehotelbuddy.core_database.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.shacklehotelbuddy.core_database.converters.DateTypeConverter
import kotlinx.parcelize.Parcelize
import java.util.Date


@Parcelize
@Entity(tableName = "search_query_table")
data class SearchQueryEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @TypeConverters(DateTypeConverter::class)
    val checkInDate: Date,

    @TypeConverters(DateTypeConverter::class)
    val checkoutDate: Date,

    val adultsCount: Int,

    val childrenCount: Int

) : Parcelable