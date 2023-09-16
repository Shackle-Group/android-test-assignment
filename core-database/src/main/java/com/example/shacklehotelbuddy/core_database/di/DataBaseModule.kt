package com.example.shacklehotelbuddy.core_database.di

import android.content.Context
import androidx.room.Room
import com.example.shacklehotelbuddy.core_database.dao.SearchQueryDao
import com.example.shacklehotelbuddy.core_database.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "shackles_db").build()

    @Singleton
    @Provides
    fun provideSearchQueryDao(appDatabase: AppDatabase): SearchQueryDao =
        appDatabase.provideSearchQueryDao()

}