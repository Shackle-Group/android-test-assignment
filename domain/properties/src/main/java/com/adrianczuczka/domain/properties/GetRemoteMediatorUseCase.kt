package com.adrianczuczka.domain.properties

import androidx.paging.ExperimentalPagingApi
import androidx.paging.RemoteMediator
import com.adrianczuczka.data.properties.PropertiesRepository
import com.adrianczuczka.data.properties.local.model.DbProperty
import javax.inject.Inject

class GetRemoteMediatorUseCase @Inject constructor(
    private val repository: PropertiesRepository,
    private val dbSearchInfoMapper: DbSearchInfoMapper,
) {

    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke(
        checkInDateMillis: Long,
        checkOutDateMillis: Long,
        adultsCount: Int,
        childrenCount: Int,
    ): RemoteMediator<Int, DbProperty> =
        repository.getPropertiesRemoteMediator(
            dbSearchInfoMapper(
                checkInDateMillis,
                checkOutDateMillis,
                adultsCount,
                childrenCount
            )
        )
}