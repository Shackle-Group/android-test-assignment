package com.example.shacklehotelbuddy.di

import com.example.shacklehotelbuddy.data.local.datasource.HotelLocalDataSource
import com.example.shacklehotelbuddy.data.local.datasource.HotelLocalDataSourceImplTest
import com.example.shacklehotelbuddy.data.remote.datasource.HotelRemoteDataSource
import com.example.shacklehotelbuddy.data.remote.datasource.HotelRemoteDataSourceImplTest
import com.example.shacklehotelbuddy.data.repository.HotelRepository
import com.example.shacklehotelbuddy.data.repository.HotelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton


@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
object DataModuleTest {

    @Provides
    @Singleton
    fun provideHotelRemoteDataSource(): HotelRemoteDataSource {
        return HotelRemoteDataSourceImplTest()
    }

    @Provides
    @Singleton
    fun provideHotelLocalDataSource(): HotelLocalDataSource {
        return HotelLocalDataSourceImplTest()
    }

    @Provides
    @Singleton
    fun provideHotelRepository(): HotelRepository {
        return HotelRepositoryImpl(HotelRemoteDataSourceImplTest(), HotelLocalDataSourceImplTest())
    }
}