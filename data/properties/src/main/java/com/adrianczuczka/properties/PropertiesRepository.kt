package com.adrianczuczka.properties

import com.adrianczuczka.properties.datasource.PropertiesRemoteDataSource
import javax.inject.Inject

class PropertiesRepository @Inject constructor(
    private val remoteDataSource: PropertiesRemoteDataSource,
) {
}