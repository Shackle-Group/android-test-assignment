package com.example.shacklehotelbuddy.features.hotels.viewModels

import com.example.shacklehotelbuddy.base.api.models.RequestResult
import com.example.shacklehotelbuddy.features.hotels.models.Hotel
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsAction
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsIntent
import com.example.shacklehotelbuddy.features.hotels.useCases.HotelsUseCase
import com.example.shacklehotelbuddy.syntaxSugar.BaseViewModelUnitTest
import com.example.shacklehotelbuddy.syntaxSugar.joinWithTimeout
import com.example.shacklehotelbuddy.syntaxSugar.runBlockingUnit
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import org.junit.Test

/**
 * Test for [HotelsViewModel].
 *
 * @constructor Create empty constructor for hotels view model test
 */
class HotelsViewModelTest : BaseViewModelUnitTest() {
    private val hotelsUseCase: HotelsUseCase = mockk()
    private val hotelsViewModel = HotelsViewModel(hotelsUseCase)

    /**
     * [HotelsIntent.LoadHotels] Success.
     */
    @Test
    fun loadHotelsSuccess() = runBlockingUnit {
        val hotels = listOf(mockk<Hotel>())
        coEvery { hotelsUseCase.getHotelsByLastRequest() } returns RequestResult.Success(hotels)

        hotelsViewModel.state.collectPost {
            hotelsViewModel.dispatchIntentAsync(HotelsIntent.LoadHotels).joinWithTimeout()
        }.apply {
            assertEquals(3, this.size)
            assertEquals(false, this[0]?.isLoading) // Default.
            assertEquals(true, this[1]?.isLoading)  // Start loading.
            assertEquals(false, this[2]?.isLoading) // Finish loading.
            assertEquals(hotels, this[2]?.hotels)
        }
    }

    /**
     * [HotelsIntent.LoadHotels] Fail.
     */
    @Test
    fun loadHotelsFail() = runBlockingUnit {
        val errorCode = 404
        val errorMessage = "Not found"
        coEvery { hotelsUseCase.getHotelsByLastRequest() } returns RequestResult.Failed(errorCode, errorMessage)

        hotelsViewModel.state.collectPost {
            hotelsViewModel.dispatchIntentAsync(HotelsIntent.LoadHotels).joinWithTimeout()
            hotelsViewModel.action.subscribeAndCompareFirstValue(HotelsAction.ShowError(errorCode, errorMessage))
        }.apply {
            assertEquals(3, this.size)
            assertEquals(false, this[0]?.isLoading) // Default.
            assertEquals(true, this[1]?.isLoading)  // Start loading.
            assertEquals(false, this[2]?.isLoading) // Finish loading.
            assertEquals(0, this[2]?.hotels?.size)
        }
    }

    /**
     * Open hotel details.
     */
    @Test
    fun openHotelDetails() = runBlockingUnit {
        val hotelId = "1"
        hotelsViewModel.action.subscribeAndCompareFirstValue(HotelsAction.OpenHotelDetails(hotelId))
        hotelsViewModel.dispatchIntentAsync(HotelsIntent.TapToHotel(hotelId)).joinWithTimeout()
    }
}