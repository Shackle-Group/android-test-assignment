package com.example.shacklehotelbuddy.features_home.domain

import com.example.shacklehotelbuddy.core_database.entities.SearchQueryEntity
import com.example.shacklehotelbuddy.features_home.data.dto.PropertyResponseDto
import com.example.shacklehotelbuddy.features_home.data.dto.SearchRequestDto
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {

    suspend fun fetchProperties(searchRequestDto: SearchRequestDto): Flow<PropertyResponseDto>
    suspend fun fetchRecentSearch(): Flow<List<SearchQueryEntity>>

    suspend fun saveRecentSearch(searchQueryEntity: SearchQueryEntity)

}