package com.adrianczuczka.domain.properties

import com.adrianczuczka.data.properties.local.model.DbSearchInfo
import javax.inject.Inject

class DbSearchInfoMapper @Inject constructor(
    private val dbDateInfoMapper: DbDateInfoMapper,
) {

    operator fun invoke(
        checkInDateMillis: Long,
        checkOutDateMillis: Long,
        adultsCount: Int,
        childrenCount: Int,
    ) = DbSearchInfo(
        regionId = "",
        checkInDate = dbDateInfoMapper(checkInDateMillis),
        checkOutDate = dbDateInfoMapper(checkOutDateMillis),
        adultsCount = adultsCount,
        childrenCount = childrenCount
    )
}