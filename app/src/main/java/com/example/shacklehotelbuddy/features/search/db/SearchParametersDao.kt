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

    /**
     * Delete.
     *
     * @param checkInTimestamp Check in timestamp
     * @param checkOutTimestamp Check out timestamp
     * @param adultCount Adult count
     * @param childrenCount Children count
     */
    @Query("DELETE FROM $SEARCH_PARAMETERS WHERE " +
            "$CHECK_IN_TIMESTAMP = :checkInTimestamp AND " +
            "$CHECK_OUT_DATE = :checkOutTimestamp AND " +
            "$ADULT_COUNT = :adultCount AND " +
            "$CHILDREN_COUNT = :childrenCount")
    fun delete(
        checkInTimestamp: Long,
        checkOutTimestamp: Long,
        adultCount: Int,
        childrenCount: Int
    )
}