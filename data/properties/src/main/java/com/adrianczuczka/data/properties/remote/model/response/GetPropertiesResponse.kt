package com.adrianczuczka.data.properties.remote.model.response

import com.adrianczuczka.data.properties.remote.model.ApiProperty
import com.adrianczuczka.data.properties.remote.model.ApiSummary

class GetPropertiesResponse(
    val data: Data,
) {
    data class Data(
        val propertySearch: PropertySearch,
    ) {
        data class PropertySearch(
            val properties: List<ApiProperty>,
            val summary: ApiSummary,
        )
    }
}