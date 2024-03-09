package com.example.shacklehotelbuddy.di

import com.example.shacklehotelbuddy.data.local.database.HotelSearchDao
import com.example.shacklehotelbuddy.data.local.datasource.HotelLocalDataSource
import com.example.shacklehotelbuddy.data.local.datasource.HotelLocalDataSourceImpl
import com.example.shacklehotelbuddy.data.remote.datasource.HotelRemoteDataSource
import com.example.shacklehotelbuddy.data.remote.datasource.HotelRemoteDataSourceImpl
import com.example.shacklehotelbuddy.data.remote.service.HotelSearchService
import com.example.shacklehotelbuddy.data.repository.HotelRepository
import com.example.shacklehotelbuddy.data.repository.HotelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun provideHotelRemoteDataSource(hotelSearchService: HotelSearchService): HotelRemoteDataSource =
        HotelRemoteDataSourceImpl(hotelSearchService)

    @Provides
    fun provideHotelLocalDataSourceImpl(hotelSearchDao: HotelSearchDao): HotelLocalDataSource =
        HotelLocalDataSourceImpl(hotelSearchDao)

    @Provides
    fun provideHotelRepository(
        remoteDataSource: HotelRemoteDataSource,
        localDataSource: HotelLocalDataSource
    ): HotelRepository = HotelRepositoryImpl(remoteDataSource, localDataSource)

}