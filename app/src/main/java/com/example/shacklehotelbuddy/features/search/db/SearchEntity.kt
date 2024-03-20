package com.example.shacklehotelbuddy.features.search.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

internal const val SEARCH = "search"

internal const val ID = "id"
internal const val START_DATE = "check_in_date"
internal const val END_DATE = "check_end_date"
internal const val ADULT_COUNT = "adult_count"
internal const val CHILDREN_COUNT = "children_count"

@Entity(tableName = SEARCH)
class SearchEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)                  val id: Long = 0,
    @ColumnInfo(name = START_DATE)          val checkInDate: Long,
    @ColumnInfo(name = END_DATE)            val checkOutDate: Long,
    @ColumnInfo(name = ADULT_COUNT)         val adultCount: Int,
    @ColumnInfo(name = CHILDREN_COUNT)      val childrenCount: Int,
)