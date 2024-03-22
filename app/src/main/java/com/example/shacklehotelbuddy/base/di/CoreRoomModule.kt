package com.example.shacklehotelbuddy.base.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import com.example.shacklehotelbuddy.base.db.AppRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors
import javax.inject.Named
import javax.inject.Singleton
import com.example.shacklehotelbuddy.features.search.db.SearchParametersDao

internal const val DATABASE_DISPATCHER = "DatabaseDispatcher"
internal const val DATABASE_NAME = "hackles_database"

@Module
@InstallIn(SingletonComponent::class)
class CoreRoomModule {
    /**
     * Provide room database.
     *
     * @param application Application
     * @param roomMigrations Room migrations
     * @return [RoomDatabase]
     */
    @Provides
    @Singleton
    fun provideRoomDatabase(
        application: Application,
        roomMigrations: Set<@JvmSuppressWildcards Migration> // We don't have migration here, but it can be added later.
    ) = Room.databaseBuilder(
        application,
        AppRoomDatabase::class.java,
        DATABASE_NAME
    ).addMigrations(*roomMigrations.toTypedArray())
        .fallbackToDestructiveMigrationOnDowngrade()
        .build()

    /**
     * All work with database should be done on a single thread.
     *
     * @return [CoroutineDispatcher]
     */
    @Provides
    @Singleton
    @Named(DATABASE_DISPATCHER)
    fun provideDatabaseDispatcher(): CoroutineDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    /**
     * Provide search dao.
     *
     * @param appRoomDatabase App room database
     * @return [SearchParametersDao]
     */
    @Provides
    @Singleton
    fun provideSearchDao(appRoomDatabase: AppRoomDatabase) = appRoomDatabase.searchDao()
}