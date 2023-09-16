package com.example.shacklehotelbuddy.features_home.di

import com.example.shacklehotelbuddy.core_database.dao.SearchQueryDao
import com.example.shacklehotelbuddy.core_utils.utils.AppDispatchers
import com.example.shacklehotelbuddy.features_home.data.api.PropertiesApi
import com.example.shacklehotelbuddy.features_home.data.api.PropertiesApiHelper
import com.example.shacklehotelbuddy.features_home.data.repositories.PropertyRepositoryImpl
import com.example.shacklehotelbuddy.features_home.domain.PropertyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePropertyRepository(
        propertiesApiHelper: PropertiesApiHelper,
        searchQueryDao: SearchQueryDao,
        appDispatchers: AppDispatchers
    ): PropertyRepository =
        PropertyRepositoryImpl(propertiesApiHelper, searchQueryDao, appDispatchers)

}