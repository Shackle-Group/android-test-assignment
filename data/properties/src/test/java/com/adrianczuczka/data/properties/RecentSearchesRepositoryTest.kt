package com.adrianczuczka.data.properties

import com.adrianczuczka.data.properties.search.SearchDao
import com.adrianczuczka.data.properties.search.SearchDatabase
import com.adrianczuczka.data.properties.search.model.DbDateInfo
import com.adrianczuczka.data.properties.search.model.DbSearchInfo
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


class RecentSearchesRepositoryTest {

    private val database: SearchDatabase = mock()

    private lateinit var recentSearchesRepository: RecentSearchesRepository

    @Before
    fun `set up`() {
        recentSearchesRepository = RecentSearchesRepository(database)
    }

    @Test
    fun `getRecentSearches - delegates to database`() = runTest {
        val search = DbSearchInfo(
            regionId = "test region id",
            checkInDate = DbDateInfo(
                day = 0,
                month = 0,
                year = 0,
                time = 0
            ),
            checkOutDate = DbDateInfo(
                day = 0,
                month = 0,
                year = 0,
                time = 0
            ),
            adultCount = 0,
            childrenCount = 0,
            timestamp = 0
        )
        val searchDao: SearchDao = mock()

        whenever(searchDao.getRecentSearches()).thenReturn(listOf(search))
        whenever(database.searchDao()).thenReturn(searchDao)

        val searches = recentSearchesRepository.getRecentSearches()

        assertThat(searches).isEqualTo(listOf(search))
    }

    @Test
    fun `insert - delegates to database`() = runTest {
        val search = DbSearchInfo(
            regionId = "test region id",
            checkInDate = DbDateInfo(
                day = 0,
                month = 0,
                year = 0,
                time = 0
            ),
            checkOutDate = DbDateInfo(
                day = 0,
                month = 0,
                year = 0,
                time = 0
            ),
            adultCount = 0,
            childrenCount = 0,
            timestamp = 0
        )
        val searchDao: SearchDao = mock()

        whenever(database.searchDao()).thenReturn(searchDao)

        recentSearchesRepository.storeSearch(search)

        verify(database).searchDao()
        verify(searchDao).insert(search)
    }
}