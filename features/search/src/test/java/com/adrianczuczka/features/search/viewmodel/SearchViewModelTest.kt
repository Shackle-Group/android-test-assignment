package com.adrianczuczka.features.search.viewmodel

import com.adrianczuczka.data.properties.RecentSearchesRepository
import com.adrianczuczka.data.properties.search.model.DbDateInfo
import com.adrianczuczka.data.properties.search.model.DbSearchInfo
import com.adrianczuczka.domain.properties.DbDateInfoMapper
import com.adrianczuczka.features.search.formatter.CurrentTimeFormatter
import com.adrianczuczka.features.search.state.SearchState
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.util.Date

@ExperimentalCoroutinesApi
class SearchViewModelTest {

    private val currentTimeFormatter: CurrentTimeFormatter = mock()
    private val searchesRepository: RecentSearchesRepository = mock()
    private val dbDateInfoMapper: DbDateInfoMapper = mock()

    private lateinit var viewModel: SearchViewModel

    @Before
    fun `set up`() {
        viewModel = SearchViewModel(
            dispatcher = UnconfinedTestDispatcher(),
            searchesRepository = searchesRepository,
            dbDateInfoMapper = dbDateInfoMapper,
            currentTimeFormatter = currentTimeFormatter
        )
    }

    @Test
    fun `onCheckInButtonClick updates state`() {
        viewModel.onCheckInButtonClick()

        val newState = viewModel.state.value
        assertThat(newState.datePickerState).isEqualTo(SearchState.DatePickerState.CHECK_IN)
    }

    @Test
    fun `onCheckOutButtonClick updates state`() {
        viewModel.onCheckOutButtonClick()

        val newState = viewModel.state.value
        assertThat(newState.datePickerState).isEqualTo(SearchState.DatePickerState.CHECK_OUT)
    }

    @Test
    fun `onCheckInDateChanged updates state`() {
        val dateMillis = System.currentTimeMillis()
        viewModel.onCheckInDateChanged(dateMillis)

        val newState = viewModel.state.value
        assertThat(newState.datePickerState).isNull()
        assertThat(newState.checkInDate).isEqualTo(Date(dateMillis))
    }

    @Test
    fun `onCheckOutDateChanged updates state`() {
        val dateMillis = System.currentTimeMillis()
        viewModel.onCheckOutDateChanged(dateMillis)

        val newState = viewModel.state.value
        assertThat(newState.datePickerState).isNull()
        assertThat(newState.checkOutDate).isEqualTo(Date(dateMillis))
    }

    @Test
    fun `onAdultCountChanged updates state`() {
        val newCount = 3
        viewModel.onAdultCountChanged(newCount)

        val newState = viewModel.state.value
        assertThat(newState.adultCount).isEqualTo(newCount)
    }

    @Test
    fun `onChildrenCountChanged updates state`() {
        val newCount = 2
        viewModel.onChildrenCountChanged(newCount)

        val newState = viewModel.state.value
        assertThat(newState.childrenCount).isEqualTo(newCount)
    }

    @Test
    fun `dismissDatePicker updates state`() {
        viewModel.dismissDatePicker()

        val newState = viewModel.state.value
        assertThat(newState.datePickerState).isNull()
    }

    @Test
    fun `loadRecentSearches updates state with recent searches`() = runTest {
        val recentSearches = listOf(
            DbSearchInfo(
                regionId = "", checkInDate = DbDateInfo(
                    day = 0,
                    month = 0,
                    year = 0,
                    time = 0
                ), checkOutDate = DbDateInfo(
                    day = 0,
                    month = 0,
                    year = 0,
                    time = 0
                ), adultCount = 0, childrenCount = 0, timestamp = 0
            )
        )
        whenever(searchesRepository.getRecentSearches()).thenReturn(recentSearches)

        viewModel.loadRecentSearches()

        val newState = viewModel.state.value
        assertThat(newState.mostRecentSearches).isEqualTo(recentSearches)
    }

    @Test
    fun `storeSearch calls repository and updates state`() = runTest {
        val checkInDateMillis = 1234L
        val checkOutDateMillis = 12345L
        val currentTime = 123456L
        val adultCount = 2
        val childrenCount = 1
        val regionId = "6200211"
        val dateInfo = DbDateInfo(
            day = 1,
            month = 2,
            year = 3,
            time = 4
        )

        val dbSearchInfo = DbSearchInfo(
            regionId = regionId,
            checkInDate = dateInfo,
            checkOutDate = dateInfo,
            adultCount = adultCount,
            childrenCount = childrenCount,
            timestamp = currentTime
        )

        whenever(dbDateInfoMapper(checkInDateMillis)).thenReturn(dateInfo)
        whenever(dbDateInfoMapper(checkOutDateMillis)).thenReturn(dateInfo)
        whenever(searchesRepository.storeSearch(dbSearchInfo)).thenReturn(Unit)
        whenever(currentTimeFormatter()).thenReturn(currentTime)

        viewModel.storeSearch(checkInDateMillis, checkOutDateMillis, adultCount, childrenCount)

        verify(searchesRepository).storeSearch(dbSearchInfo)
    }
}
