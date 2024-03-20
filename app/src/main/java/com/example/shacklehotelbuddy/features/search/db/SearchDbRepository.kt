package com.example.shacklehotelbuddy.features.search.db

import com.example.shacklehotelbuddy.base.db.IDbRepository
import com.example.shacklehotelbuddy.base.di.DATABASE_DISPATCHER
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class SearchDbRepository @Inject constructor(
    private val searchDao: SearchDao,
    @Named(DATABASE_DISPATCHER) private val databaseDispatcher: CoroutineDispatcher
) : IDbRepository {
    suspend fun getSearches() = withContext(databaseDispatcher) {
        searchDao.getSearches()
    }

    suspend fun insert(searchEntity: SearchEntity) = withContext(databaseDispatcher) {
        searchDao.insert(searchEntity)
    }
}