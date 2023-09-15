package com.example.shacklehotelbuddy.features_home.data.api

import com.example.shacklehotelbuddy.features_home.data.dto.PropertyResponseDto
import com.example.shacklehotelbuddy.features_home.data.dto.SearchRequestDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface PropertiesApi {

    @POST("properties/v2/list")
    suspend fun fetchProperties(
        @Query("resultsStartingIndex") resultsStartingIndex: Int = 0,
        @Body searchRequestDto: SearchRequestDto
    ): Flow<PropertyResponseDto>

}