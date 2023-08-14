package com.adrianczuczka.data.properties.local.mapper

import com.adrianczuczka.data.properties.local.model.DbProperty
import com.adrianczuczka.data.properties.remote.model.ApiProperty
import javax.inject.Inject

class ApiPropertyToDbPropertyMapper @Inject constructor() {
    operator fun invoke(apiProperty: ApiProperty) =
        DbProperty(
            id = apiProperty.id,
            name = apiProperty.name
        )
}