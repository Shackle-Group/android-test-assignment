package com.adrianczuczka.domain.properties

import com.adrianczuczka.data.properties.remote.model.ApiDateInfo
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class ApiDateInfoMapper @Inject constructor() {
    operator fun invoke(
        dateMillis: Long,
    ): ApiDateInfo {
        val calendar = Calendar.getInstance()
        calendar.time = Date(dateMillis)
        return ApiDateInfo(
            day = calendar[Calendar.DAY_OF_MONTH],
            month = calendar[Calendar.MONTH],
            year = calendar[Calendar.YEAR]
        )
    }
}