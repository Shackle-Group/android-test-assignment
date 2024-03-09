package com.example.shacklehotelbuddy.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.shacklehotelbuddy.data.local.model.HotelSearchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HotelSearchDao {

    @Upsert
    fun cacheHotelSearch(query: HotelSearchEntity)

    @Query("SELECT * FROM HotelSearchEntity")
    fun getCachedHotelSearches(): Flow<List<HotelSearchEntity>>

    /** added for testing purpose */
    @Delete
    fun deleteHotelSearch(query: List<HotelSearchEntity>)
}