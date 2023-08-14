package com.adrianczuczka.data.properties.remote

import com.adrianczuczka.data.properties.remote.model.ApiDateInfo
import com.adrianczuczka.data.properties.remote.model.ApiDestination
import com.adrianczuczka.data.properties.remote.model.ApiRoom
import com.adrianczuczka.data.properties.remote.model.response.GetPropertiesResponse
import retrofit2.http.POST

interface PropertiesService {
    @POST("properties/v2/list")
    suspend fun getProperties(
        destination: ApiDestination,
        checkInDate: ApiDateInfo,
        checkOutDate: ApiDateInfo,
        rooms: List<ApiRoom>,
        resultsStartingIndex: Int,
        resultsSize: Int = 20,
    ): GetPropertiesResponse
}