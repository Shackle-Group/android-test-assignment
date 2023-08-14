package com.adrianczuczka.data.properties.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("properties")
data class DbProperty(
    @PrimaryKey
    val id: String,
    val name: String,
)