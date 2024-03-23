package com.example.shacklehotelbuddy.features.search.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

internal const val SEARCH_PARAMETERS = "search_parameters"

internal const val ID = "id"
internal const val CHECK_IN_TIMESTAMP = "check_in_timestamp"
internal const val CHECK_OUT_DATE = "check_end_timestamp"
internal const val ADULT_COUNT = "adult_count"
internal const val CHILDREN_COUNT = "children_count"

/**
 * Search parameters entity.
 *
 * @property id Unique identifier
 * @property checkInTimestamp Check in timestamp
 * @property checkOutTimestamp Check out timestamp
 * @property adultCount Adult count
 * @property childrenCount Children count
 * @constructor Create [SearchParametersEntity]
 */
@Entity(tableName = SEARCH_PARAMETERS)
data class SearchParametersEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)                      val id: Long = 0,
    @ColumnInfo(name = CHECK_IN_TIMESTAMP)      val checkInTimestamp: Long,
    @ColumnInfo(name = CHECK_OUT_DATE)          val checkOutTimestamp: Long,
    @ColumnInfo(name = ADULT_COUNT)             val adultCount: Int,
    @ColumnInfo(name = CHILDREN_COUNT)          val childrenCount: Int,
)