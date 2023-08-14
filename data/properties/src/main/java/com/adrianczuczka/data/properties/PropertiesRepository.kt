package com.adrianczuczka.data.properties

import androidx.paging.PagingSource
import com.adrianczuczka.data.properties.remote.PropertiesService
import com.adrianczuczka.data.properties.remote.model.ApiProperty
import com.adrianczuczka.data.properties.remote.model.ApiSearchInfo
import javax.inject.Inject

class PropertiesRepository @Inject constructor(
    private val service: PropertiesService,
) {

    fun getPropertiesPagingSource(searchInfo: ApiSearchInfo): PagingSource<Int, ApiProperty> =
        PropertiesPagingSource(
            service,
            searchInfo
        )
}