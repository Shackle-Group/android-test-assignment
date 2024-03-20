package com.example.shacklehotelbuddy.features.search.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SearchDao {
    @Query("SELECT * FROM SEARCH")
    fun getSearches(): List<SearchEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(searchEntity: SearchEntity)
}