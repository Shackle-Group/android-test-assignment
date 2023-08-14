package com.adrianczuczka.data.properties.local.remotekey

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.adrianczuczka.data.properties.local.model.DbSearchInfo

@Entity(tableName = "remote_keys")
data class RemoteKey(
    @PrimaryKey
    val searchInfo: DbSearchInfo,
    val nextKey: Int?,
)
