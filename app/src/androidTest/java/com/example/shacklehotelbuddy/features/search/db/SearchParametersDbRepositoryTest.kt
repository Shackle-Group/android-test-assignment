package com.example.shacklehotelbuddy.features.search.db

import com.example.shacklehotelbuddy.base.db.AppRoomDatabase
import com.example.shacklehotelbuddy.syntaxSugar.BaseRoomRepositoryTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

/**
 * Test for [SearchParametersDbRepository].
 *
 * @constructor Create empty constructor for search parameters db repository test
 */
class SearchParametersDbRepositoryTest : BaseRoomRepositoryTest<AppRoomDatabase>(AppRoomDatabase::class) {
    private val searchParameterGenerator = SearchParameterGenerator()
    private lateinit var searchParametersDbRepository: SearchParametersDbRepository

    override fun beforeTest() {
        super.beforeTest()
        searchParametersDbRepository = SearchParametersDbRepository(
            searchParametersDao = db.searchDao(),
            databaseDispatcher = unconfinedTestDispatcher
        )
    }

    /**
     * Insert value and get back.
     */
    @Test
    fun insertAndGetBack() = runTest {
        assertEquals(0, searchParametersDbRepository.getLastSearchParameters(1).size)

        val searchParameters = searchParameterGenerator.getMockk1()
        searchParametersDbRepository.insertOrUpdate(searchParameters)
        val result = searchParametersDbRepository.getLastSearchParameters(1)
        assertEquals(1, result.size)
        assertEquals(searchParameters, result.first())
    }

    /**
     * Check possibility to create duplicate.
     */
    @Test
    fun tryToDuplicateSameSearchParams() = runTest {
        val searchParameters = searchParameterGenerator.getMockk1()
        searchParametersDbRepository.insertOrUpdate(searchParameters)
        searchParametersDbRepository.insertOrUpdate(searchParameters)
        searchParametersDbRepository.insertOrUpdate(searchParameters)
        val result = searchParametersDbRepository.getLastSearchParameters(1)
        assertEquals(1, result.size)
        assertEquals(searchParameters, result.first())
    }
}