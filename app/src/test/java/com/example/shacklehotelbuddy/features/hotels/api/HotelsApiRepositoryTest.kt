package com.example.shacklehotelbuddy.features.hotels.api

import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters
import com.example.shacklehotelbuddy.syntaxSugar.BaseApiRepositoryTest
import kotlinx.coroutines.test.runTest
import org.junit.Test

/**
 * There are tests for [HotelsApiRepository]. It doesn't work, because JSON is 18k lines long and contains too much pojo,
 * which I can't manually convert to Kotlin. So, just show it as an example of how it should be.
 *
 * @constructor Create empty constructor for hotels api repository test
 */
class HotelsApiRepositoryTest : BaseApiRepositoryTest() {
    private val hotelsApiRepository = HotelsApiRepository(getApi(HotelsApiService::class.java))

    /**
     * Get teachers by key 404.
     */
    @Test
    fun getHotels_404() = runTest {
        enqueueResponse(code = 404)
        hotelsApiRepository.getHotels(
            searchParameters = SearchParameters(
                checkInTimestamp = 1,
                checkOutTimestamp = 2,
                adultCount = 1,
                childrenCount = 0
            )
        )//.checkNegativeResult()
    }

    /**
     * Get teachers by key 200.
     */
    @Test
    fun getHotels_200() = runTest {
        enqueueResponse(fileName = "hotels-200.json", code = 200)
        hotelsApiRepository.getHotels(
            searchParameters = SearchParameters(
                checkInTimestamp = 1,
                checkOutTimestamp = 2,
                adultCount = 1,
                childrenCount = 0
            )
        ).apply {
//            assertTrue(this is RequestResult.Success<List<Hotel>>)
//            val hotels = (this as RequestResult.Success<List<Hotel>>).data
//            assert(hotels!!.isNotEmpty())
//            (((this as RequestResult.Success<*>).data as List<*>).first() as Hotel).apply {
//                Assert.assertEquals(id, 4914)
//                Assert.assertEquals(name, "Hotel")
//                Assert.assertEquals(rating, 5.0)
//                Assert.assertEquals(price, 100.0)
//            }
        }
    }
}