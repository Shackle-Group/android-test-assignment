package com.adrianczuczka.data.properties

import com.adrianczuczka.data.properties.search.SearchDatabase
import com.adrianczuczka.data.properties.search.model.DbSearchInfo
import javax.inject.Inject

class RecentSearchesRepository @Inject constructor(
    private val database: SearchDatabase,
) {

    suspend fun getRecentSearches(): List<DbSearchInfo> =
        database.searchDao().getRecentSearches()

    suspend fun storeSearch(searchInfo: DbSearchInfo) = database.searchDao().insert(searchInfo)
}