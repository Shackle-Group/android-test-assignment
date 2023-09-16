package com.example.shacklehotelbuddy.features_home.di

import com.example.shacklehotelbuddy.core_utils.utils.AppDispatchers
import com.example.shacklehotelbuddy.features_home.data.api.PropertiesApi
import com.example.shacklehotelbuddy.features_home.data.api.PropertiesApiHelper
import com.example.shacklehotelbuddy.features_home.data.api.PropertiesApiHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PropertyModule {
    @Provides
    @Singleton
    fun providesPropertyApi(retrofit: Retrofit): PropertiesApi =
        retrofit.create(PropertiesApi::class.java)

    @Provides
    @Singleton
    fun providePropertiesApiHelper(
        propertiesApi: PropertiesApi,
        appDispatchers: AppDispatchers
    ): PropertiesApiHelper = PropertiesApiHelperImpl(propertiesApi, appDispatchers)
}