package com.adrianczuczka.data.properties.remote.model.response

import com.adrianczuczka.data.properties.remote.model.ApiProperty
import com.adrianczuczka.data.properties.remote.model.ApiSummary

class GetPropertiesResponse(
    val properties: List<ApiProperty>,
    val summary: ApiSummary,
)