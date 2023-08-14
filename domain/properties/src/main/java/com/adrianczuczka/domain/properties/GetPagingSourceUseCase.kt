package com.adrianczuczka.domain.properties

import com.adrianczuczka.data.properties.PropertiesRepository
import javax.inject.Inject

class GetPagingSourceUseCase @Inject constructor(
    private val repository: PropertiesRepository,
    private val apiSearchInfoMapper: ApiSearchInfoMapper,
) {

    operator fun invoke(
        checkInDateMillis: Long,
        checkOutDateMillis: Long,
        adultsCount: Int,
        childrenCount: Int,
    ) = repository.getPropertiesPagingSource(
        apiSearchInfoMapper(
            checkInDateMillis,
            checkOutDateMillis,
            adultsCount,
            childrenCount
        )
    )
}