package com.example.shacklehotelbuddy.presentation.ui.main

import com.example.shacklehotelbuddy.MainCoroutineRule
import com.example.shacklehotelbuddy.domain.repository.HotelRepository
import com.example.shacklehotelbuddy.di.DataModule
import com.example.shacklehotelbuddy.domain.model.SearchDate
import com.example.shacklehotelbuddy.domain.usecase.CacheHotelSearchUseCase
import com.example.shacklehotelbuddy.domain.usecase.GetCachedHotelSearchesUseCase
import com.example.shacklehotelbuddy.domain.usecase.SearchHotelsUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import dagger.hilt.android.testing.UninstallModules
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltAndroidTest
@Config(application = HiltTestApplication::class)
@RunWith(RobolectricTestRunner::class)
@UninstallModules(value = [DataModule::class])
class MainViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var hotelRepository: HotelRepository

    private var getCachedHotelSearchesUseCase: GetCachedHotelSearchesUseCase = mockk()

    private var cacheHotelSearchUseCase: CacheHotelSearchUseCase = mockk()

    private var searchHotelsUseCase: SearchHotelsUseCase = mockk()

    @Before
    fun setup() {
        hiltRule.inject()
        viewModel = MainViewModel(
            searchHotelsUseCase,
            cacheHotelSearchUseCase,
            getCachedHotelSearchesUseCase
        )
    }

    @Test
    fun `test updateCheckInDate`() = runTest {
        viewModel.updateCheckInDate(1, 1, 2000)
        val result = viewModel.hotelSearch.value.checkInDate

        assertEquals(SearchDate("1", "1", "2000"), result)
    }

    @Test
    fun `test updateCheckOutDate`() = runTest {
        viewModel.updateCheckOutDate(1, 1, 2000)
        val result = viewModel.hotelSearch.value.checkOutDate

        assertEquals(SearchDate("1", "1", "2000"), result)
    }

    @Test
    fun `test updateAdults`() = runTest {
        viewModel.updateAdults("10")
        val result = viewModel.hotelSearch.value.adults

        assertEquals(10, result)
    }

    @Test
    fun `test updateAdults with increment true`() = runTest {
        viewModel.updateAdults("10")
        viewModel.updateAdults(increment = true)

        val result = viewModel.hotelSearch.value.adults

        assertEquals(11, result)
    }

    @Test
    fun `test updateAdults with increment false`() = runTest {
        viewModel.updateAdults("10")
        viewModel.updateAdults(increment = false)

        val result = viewModel.hotelSearch.value.adults

        assertEquals(9, result)
    }

    @Test
    fun `test updateChildren`() = runTest {
        viewModel.updateChildren("1")
        val result = viewModel.hotelSearch.value.children

        assertEquals(1, result)
    }

    @Test
    fun `test updateChildren with increment true`() = runTest {
        viewModel.updateChildren("1")
        viewModel.updateChildren(true)

        val result = viewModel.hotelSearch.value.children

        assertEquals(2, result)
    }

    @Test
    fun `test updateChildren with increment false`() = runTest {
        viewModel.updateChildren("1")
        viewModel.updateChildren(false)

        val result = viewModel.hotelSearch.value.children

        assertEquals(0, result)
    }
}
