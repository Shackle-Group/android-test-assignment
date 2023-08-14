package com.adrianczuczka.data.properties.remote.model

data class ApiSearchInfo(
    val destination: ApiDestination,
    val checkInDate: ApiDateInfo,
    val checkOutDate: ApiDateInfo,
    val rooms: List<ApiRoom>,
)