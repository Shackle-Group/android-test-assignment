package com.adrianczuczka.data.properties.search

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context): SearchDatabase =
        Room.databaseBuilder(
            context = context,
            klass = SearchDatabase::class.java,
            name = "search-database"
        ).build()
}