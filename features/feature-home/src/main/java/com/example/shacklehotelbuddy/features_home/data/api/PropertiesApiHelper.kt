package com.example.shacklehotelbuddy.features_home.data.api

import android.util.Log
import com.example.shacklehotelbuddy.core_utils.utils.AppDispatchers
import com.example.shacklehotelbuddy.features_home.data.dto.Property
import com.example.shacklehotelbuddy.features_home.data.dto.PropertyResponseDto
import com.example.shacklehotelbuddy.features_home.data.dto.SearchRequestDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Inject


interface PropertiesApiHelper {
    suspend fun fetchProperties(searchRequestDto: SearchRequestDto?): Flow<List<Property?>>
}

class PropertiesApiHelperImpl @Inject constructor(
    private val propertiesApi: PropertiesApi, private val appDispatchers: AppDispatchers
) : PropertiesApiHelper {
    override suspend fun fetchProperties(searchRequestDto: SearchRequestDto?): Flow<List<Property?>> =
        flow {
            propertiesApi.fetchProperties(searchRequestDto).data?.propertySearch?.properties?.let {
                it.let { emit(it) }

                Log.d(
                    "PropertiesApiHelper",
                    "PropertiesApiHelper: ${it}"
                )
            }
        }.flowOn(appDispatchers.io())

}