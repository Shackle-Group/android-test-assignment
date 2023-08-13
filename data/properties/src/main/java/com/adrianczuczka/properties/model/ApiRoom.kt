package com.adrianczuczka.properties.model

internal data class ApiRoom(
    val adults: Int,
    val children: List<ApiChild>,
)