package com.adrianczuczka.data.properties.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("property_searches")
data class DbPropertySearch(
    @PrimaryKey
    val searchInfo: DbSearchInfo,
    val propertyIds: List<String>,
)