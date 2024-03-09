package com.example.shacklehotelbuddy.di

import android.content.Context
import androidx.room.Room
import com.example.shacklehotelbuddy.data.local.database.HotelSearchDao
import com.example.shacklehotelbuddy.data.local.database.HotelSearchDatabase
import com.example.shacklehotelbuddy.domain.AppConstants.DATABASE_HOTEL_SEARCH
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideHotelSearchDatabase(@ApplicationContext context: Context): HotelSearchDatabase =
        Room.databaseBuilder(
            context,
            HotelSearchDatabase::class.java,
            DATABASE_HOTEL_SEARCH
        ).build()

    @Singleton
    @Provides
    fun provideHotelSearchDao(database: HotelSearchDatabase): HotelSearchDao =
        database.hotelSearchDao()

}