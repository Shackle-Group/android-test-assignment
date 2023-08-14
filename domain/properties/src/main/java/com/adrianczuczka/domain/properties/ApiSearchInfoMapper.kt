package com.adrianczuczka.domain.properties

import com.adrianczuczka.data.properties.remote.model.ApiChild
import com.adrianczuczka.data.properties.remote.model.ApiDestination
import com.adrianczuczka.data.properties.remote.model.ApiRoom
import com.adrianczuczka.data.properties.remote.model.ApiSearchInfo
import javax.inject.Inject

class ApiSearchInfoMapper @Inject constructor(
    private val apiDateInfoMapper: ApiDateInfoMapper,
) {

    operator fun invoke(
        checkInDateMillis: Long,
        checkOutDateMillis: Long,
        adultsCount: Int,
        childrenCount: Int,
    ) = ApiSearchInfo(
        destination = ApiDestination("6200211"), // Hardcoded region id
        checkInDate = apiDateInfoMapper(checkInDateMillis),
        checkOutDate = apiDateInfoMapper(checkOutDateMillis),
        rooms = listOf(
            ApiRoom(
                adults = adultsCount,
                children = List(childrenCount) {
                    // Hardcoded age
                    ApiChild(5)
                }
            )
        ),
    )
}