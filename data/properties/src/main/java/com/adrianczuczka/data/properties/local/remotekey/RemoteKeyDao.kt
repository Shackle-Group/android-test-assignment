package com.adrianczuczka.data.properties.local.remotekey

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adrianczuczka.data.properties.local.model.DbSearchInfo

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(remoteKey: RemoteKey)

    @Query("SELECT * FROM remote_keys WHERE searchInfo = :searchInfo")
    suspend fun remoteKeyBySearchInfo(searchInfo: DbSearchInfo): RemoteKey

    @Query("DELETE FROM remote_keys WHERE searchInfo = :searchInfo")
    suspend fun deleteBySearchInfo(searchInfo: DbSearchInfo)
}