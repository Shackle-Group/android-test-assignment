package com.example.shacklehotelbuddy.core_utils.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.shacklehotelbuddy.core_utils.utils.AppDispatchers
import com.example.shacklehotelbuddy.core_utils.utils.AppDispatchersImpl
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppDispatchersModule {

    @Provides
    @Singleton
    fun provideAppDispatchers(): AppDispatchers = AppDispatchersImpl()
}