package com.example.shacklehotelbuddy.features.search.db

import com.example.shacklehotelbuddy.base.di.DATABASE_DISPATCHER
import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Search parameters database repository.
 *
 * @property searchParametersDao [SearchParametersDao]
 * @property databaseDispatcher [CoroutineDispatcher]
 * @constructor Create [SearchParametersDbRepository]
 */
@Singleton
class SearchParametersDbRepository @Inject constructor(
    private val searchParametersDao: SearchParametersDao,
    @Named(DATABASE_DISPATCHER) private val databaseDispatcher: CoroutineDispatcher
) : ISearchParametersDbRepository {
    override suspend fun getLastActualSearches(count: Int): List<SearchParameters> =
        withContext(databaseDispatcher) {
            searchParametersDao.getLastActualSearches(count).map {
                it.convertToSearchParameters()
            }
        }

    override suspend fun insert(searchParameters: SearchParameters) = withContext(databaseDispatcher) {
        searchParametersDao.insert(searchParameters.convertToSearchParametersEntity())
    }

    /**
     * Convert to search parameters entity.
     *
     * @receiver [SearchParameters]
     * @return [SearchParametersEntity]
     */
    private fun SearchParameters.convertToSearchParametersEntity(): SearchParametersEntity = SearchParametersEntity(
        checkInTimestamp = this.checkInTimestamp,
        checkOutTimestamp = this.checkOutTimestamp,
        adultCount = this.adultCount,
        childrenCount = this.childrenCount
    )

    /**
     * Convert to search parameters.
     *
     * @receiver [SearchParametersEntity]
     * @return [SearchParameters]
     */
    private fun SearchParametersEntity.convertToSearchParameters(): SearchParameters = SearchParameters(
        checkInTimestamp = this.checkInTimestamp,
        checkOutTimestamp = this.checkOutTimestamp,
        adultCount = this.adultCount,
        childrenCount = this.childrenCount
    )
}