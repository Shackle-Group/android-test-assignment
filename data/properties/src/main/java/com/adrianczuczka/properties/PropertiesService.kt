package com.adrianczuczka.properties

import com.adrianczuczka.properties.datasource.PropertiesRemoteDataSource
import com.adrianczuczka.properties.model.ApiDateInfo
import com.adrianczuczka.properties.model.ApiDestination
import com.adrianczuczka.properties.model.ApiRoom
import com.adrianczuczka.properties.model.response.GetPropertiesResponse
import retrofit2.http.POST

internal interface PropertiesService : PropertiesRemoteDataSource {
    @POST("properties/v2/list")
    suspend fun getProperties(
        destination: ApiDestination = ApiDestination(regionId = "6200211"),
        checkInDate: ApiDateInfo,
        checkOutDate: ApiDateInfo,
        rooms: List<ApiRoom>,
        resultsStartingIndex: Int,
        resultsSize: Int,
    ): GetPropertiesResponse
}