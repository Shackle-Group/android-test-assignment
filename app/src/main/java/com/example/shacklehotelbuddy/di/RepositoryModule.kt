package com.example.shacklehotelbuddy.di;

import com.example.shacklehotelbuddy.data.repository.HotelRepository
import com.example.shacklehotelbuddy.data.repository.HotelRepositoryImpl
import dagger.Binds
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
public abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindHotelListRepository(hotelRepositoryImpl: HotelRepositoryImpl): HotelRepository
}
