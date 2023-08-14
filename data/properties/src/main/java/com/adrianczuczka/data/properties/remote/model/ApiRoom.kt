package com.adrianczuczka.data.properties.remote.model

data class ApiRoom(
    val adults: Int,
    val children: List<ApiChild>,
)