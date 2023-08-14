package com.adrianczuczka.domain.properties

import com.adrianczuczka.data.properties.PropertiesRepository
import javax.inject.Inject

class GetPagingSourceUseCase @Inject constructor(
    private val repository: PropertiesRepository,
    private val dbSearchInfoMapper: DbSearchInfoMapper,
) {

    operator fun invoke(
        checkInDateMillis: Long,
        checkOutDateMillis: Long,
        adultsCount: Int,
        childrenCount: Int,
    ) = repository.getPropertiesPagingSource(
        dbSearchInfoMapper(
            checkInDateMillis,
            checkOutDateMillis,
            adultsCount,
            childrenCount
        )
    )
}