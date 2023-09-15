package com.example.shacklehotelbuddy.features_home.data.repositories

import com.example.shacklehotelbuddy.core_database.dao.SearchQueryDao
import com.example.shacklehotelbuddy.core_database.entities.SearchQueryEntity
import com.example.shacklehotelbuddy.core_utils.utils.AppDispatchers
import com.example.shacklehotelbuddy.features_home.data.api.PropertiesApi
import com.example.shacklehotelbuddy.features_home.data.dto.PropertyResponseDto
import com.example.shacklehotelbuddy.features_home.data.dto.SearchRequestDto
import com.example.shacklehotelbuddy.features_home.domain.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PropertyRepositoryImpl @Inject constructor(
    val propertyApi: PropertiesApi,
    val searchQueryDao: SearchQueryDao,
    val appDispatchers: AppDispatchers
) : PropertyRepository {
    override suspend fun fetchProperties(searchRequestDto: SearchRequestDto): Flow<PropertyResponseDto> =
        propertyApi.fetchProperties(searchRequestDto = searchRequestDto).flowOn(appDispatchers.io())

    override suspend fun fetchRecentSearch(): Flow<List<SearchQueryEntity>> =
        searchQueryDao.fetchAllSearchQueryEntities().flowOn(appDispatchers.io())

    override suspend fun saveRecentSearch(searchQueryEntity: SearchQueryEntity) {
        withContext(appDispatchers.io()) {
            searchQueryDao.insert(searchQueryEntity)
        }
    }
}