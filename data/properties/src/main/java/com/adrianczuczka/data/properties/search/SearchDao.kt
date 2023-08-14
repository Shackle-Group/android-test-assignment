package com.adrianczuczka.data.properties.search

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adrianczuczka.data.properties.search.model.DbSearchInfo

@Dao
interface SearchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(searchInfo: DbSearchInfo)

    @Query("SELECT * FROM searches ORDER BY timestamp DESC LIMIT 5")
    suspend fun getRecentSearches(): List<DbSearchInfo>
}