package com.adrianczuczka.data.properties.remote.model.request

import com.adrianczuczka.data.properties.remote.model.ApiDateInfo
import com.adrianczuczka.data.properties.remote.model.ApiDestination
import com.adrianczuczka.data.properties.remote.model.ApiRoom

data class GetPropertiesRequest(
    val destination: ApiDestination,
    val checkInDate: ApiDateInfo,
    val checkOutDate: ApiDateInfo,
    val rooms: List<ApiRoom>,
    val resultsStartingIndex: Int,
    val resultsSize: Int = 20,
)