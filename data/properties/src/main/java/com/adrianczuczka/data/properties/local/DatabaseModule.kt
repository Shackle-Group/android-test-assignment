package com.adrianczuczka.data.properties.local

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
    fun provideRoomDb(@ApplicationContext context: Context): PropertiesDatabase =
        Room.databaseBuilder(
            context = context,
            klass = PropertiesDatabase::class.java,
            name = "properties-database"
        ).build()
}