package com.adrianczuczka.data.properties.remote.mapper

import com.adrianczuczka.data.properties.local.model.DbSearchInfo
import com.adrianczuczka.data.properties.remote.model.ApiChild
import com.adrianczuczka.data.properties.remote.model.ApiDestination
import com.adrianczuczka.data.properties.remote.model.ApiRoom
import com.adrianczuczka.data.properties.remote.model.ApiSearchInfo
import javax.inject.Inject

class DbSearchInfoToApiSearchInfoMapper @Inject constructor(
    private val dbDateInfoToApiDateInfoMapper: DbDateInfoToApiDateInfoMapper,
) {

    operator fun invoke(dbSearchInfo: DbSearchInfo) = ApiSearchInfo(
        destination = ApiDestination(regionId = dbSearchInfo.regionId),
        checkInDate = dbDateInfoToApiDateInfoMapper(dbSearchInfo.checkInDate),
        checkOutDate = dbDateInfoToApiDateInfoMapper(dbSearchInfo.checkOutDate),
        rooms = listOf(
            ApiRoom(
                adults = dbSearchInfo.adultsCount,
                children = List(dbSearchInfo.childrenCount) {
                    // Hardcoded age
                    ApiChild(5)
                }
            )
        )
    )
}