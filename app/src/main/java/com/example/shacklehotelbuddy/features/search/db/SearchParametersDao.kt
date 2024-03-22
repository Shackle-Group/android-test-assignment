package com.example.shacklehotelbuddy.features.search.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Stores search parameters.
 */
@Dao
interface SearchParametersDao {
    /**
     * Get last actual searches.
     *
     * @param count Count of rows
     * @return List of search parameters.
     */
    @Query("SELECT * FROM SEARCH_PARAMETERS ORDER BY id DESC LIMIT :count")
    fun getLastActualSearches(count: Int): List<SearchParametersEntity>

    /**
     * Insert search parameters.
     *
     * @param searchParametersEntity [SearchParametersEntity]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(searchParametersEntity: SearchParametersEntity)
}