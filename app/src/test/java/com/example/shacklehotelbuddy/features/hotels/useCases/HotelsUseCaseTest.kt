package com.example.shacklehotelbuddy.features.hotels.useCases

import com.example.shacklehotelbuddy.base.api.models.RequestResult
import com.example.shacklehotelbuddy.features.hotels.api.HotelsApiRepository
import com.example.shacklehotelbuddy.features.hotels.models.Hotel
import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters
import com.example.shacklehotelbuddy.features.search.db.SearchParametersDbRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

/**
 * Tests for [HotelsUseCase].
 *
 * @constructor Create empty constructor for hotels use case test
 */
class HotelsUseCaseTest {
    private val searchParametersDbRepository: SearchParametersDbRepository = mockk()
    private val hotelsApiRepository: HotelsApiRepository = mockk()
    private val hotelsUseCase: HotelsUseCase = HotelsUseCase(
        searchParametersDbRepository = searchParametersDbRepository,
        hotelsApiRepository = hotelsApiRepository
    )

    @Test
    fun `getHotelsByLastRequest success`() = runTest {
        val searchParameters = mockk<SearchParameters>()
        val result = RequestResult.Success(data = emptyList<Hotel>())
        coEvery { searchParametersDbRepository.getLastSearchParameters(1) } returns listOf(searchParameters)
        coEvery { hotelsApiRepository.getHotels(searchParameters) } returns result

        assertEquals(result, hotelsUseCase.getHotelsByLastRequest())

        coVerify(exactly = 1) {
            searchParametersDbRepository.getLastSearchParameters(1)
            hotelsApiRepository.getHotels(searchParameters)
        }
    }

    @Test
    fun `getHotelsByLastRequest fail`() = runTest {
        coEvery { searchParametersDbRepository.getLastSearchParameters(1) } returns listOf()

        assertEquals(
            RequestResult.Failed(code = 0, errorMessage = "No search parameters found"),
            hotelsUseCase.getHotelsByLastRequest()
        )

        coVerify(exactly = 1) {
            searchParametersDbRepository.getLastSearchParameters(1)
        }
    }
}