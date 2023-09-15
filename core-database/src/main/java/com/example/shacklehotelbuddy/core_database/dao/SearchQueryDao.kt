package com.example.shacklehotelbuddy.core_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shacklehotelbuddy.core_database.entities.SearchQueryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchQueryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<SearchQueryEntity?>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: SearchQueryEntity)

    @Query("SELECT * FROM search_query_table")
    fun fetchAllSearchQueryEntities(): Flow<List<SearchQueryEntity>>
}