package com.adrianczuczka.data.properties.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adrianczuczka.data.properties.local.model.DbProperty
import com.adrianczuczka.data.properties.local.model.DbSearchInfo

@Dao
interface PropertiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<DbProperty>)

    @Query(
        """
        SELECT *
        FROM properties p 
        WHERE p.id IN (
                SELECT propertyIds 
                FROM property_searches 
                WHERE searchInfo = :searchInfo
        )
        """
    )
    fun pagingSource(searchInfo: DbSearchInfo): PagingSource<Int, DbProperty>

    @Query("DELETE FROM property_searches WHERE searchInfo = :searchInfo")
    suspend fun deleteBySearchInfo(searchInfo: DbSearchInfo)

    @Query("SELECT * FROM properties WHERE id=:propertyId LIMIT 1")
    suspend fun getPropertyById(propertyId: String): DbProperty?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateProperty(property: DbProperty)
}