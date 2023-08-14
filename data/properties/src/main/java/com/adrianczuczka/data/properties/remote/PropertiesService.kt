package com.adrianczuczka.data.properties.remote

import com.adrianczuczka.data.properties.remote.model.request.GetPropertiesRequest
import com.adrianczuczka.data.properties.remote.model.response.GetPropertiesResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface PropertiesService {

    @POST("properties/v2/list")
    suspend fun getProperties(@Body request: GetPropertiesRequest): GetPropertiesResponse
}