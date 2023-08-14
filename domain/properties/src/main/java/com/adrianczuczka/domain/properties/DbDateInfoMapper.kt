package com.adrianczuczka.domain.properties

import com.adrianczuczka.data.properties.search.model.DbDateInfo
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class DbDateInfoMapper @Inject constructor() {
    operator fun invoke(
        dateMillis: Long,
    ): DbDateInfo {
        val calendar = Calendar.getInstance()
        calendar.time = Date(dateMillis)
        return DbDateInfo(
            day = calendar[Calendar.DAY_OF_MONTH],
            month = calendar[Calendar.MONTH],
            year = calendar[Calendar.YEAR],
            time = dateMillis
        )
    }
}