package com.adrianczuczka.data.properties.remote.mapper

import com.adrianczuczka.data.properties.local.model.DbDateInfo
import com.adrianczuczka.data.properties.remote.model.ApiDateInfo
import javax.inject.Inject

class DbDateInfoToApiDateInfoMapper @Inject constructor() {
    operator fun invoke(dbDateInfo: DbDateInfo) = ApiDateInfo(
        day = dbDateInfo.day,
        month = dbDateInfo.month,
        year = dbDateInfo.year
    )
}