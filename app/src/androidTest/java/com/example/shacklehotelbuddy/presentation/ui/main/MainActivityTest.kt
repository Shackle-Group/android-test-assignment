package com.example.shacklehotelbuddy.presentation.ui.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.shacklehotelbuddy.MyTestActivity
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.domain.repository.HotelRepository
import com.example.shacklehotelbuddy.domain.usecase.CacheHotelSearchUseCase
import com.example.shacklehotelbuddy.domain.usecase.GetCachedHotelSearchesUseCase
import com.example.shacklehotelbuddy.domain.usecase.SearchHotelsUseCase
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.presentation.ui.views.HotelListScreen
import com.example.shacklehotelbuddy.presentation.ui.views.MainSearchScreen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class MainActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MyTestActivity>()
    private val activity get() = composeTestRule.activity

    @Inject
    lateinit var repository: HotelRepository

    @MockK
    private lateinit var getCachedHotelSearchesUseCase: GetCachedHotelSearchesUseCase

    @MockK
    private lateinit var cacheHotelSearchUseCase: CacheHotelSearchUseCase

    @MockK
    private lateinit var searchHotelsUseCase: SearchHotelsUseCase

    private lateinit var viewModel: MainViewModel
    private lateinit var navController: TestNavHostController

    @Before
    fun init() {
        hiltRule.inject()

        searchHotelsUseCase =  SearchHotelsUseCase(repository)
        cacheHotelSearchUseCase =  CacheHotelSearchUseCase(repository)
        getCachedHotelSearchesUseCase =  GetCachedHotelSearchesUseCase(repository)

        viewModel = MainViewModel(
            searchHotelsUseCase,
            cacheHotelSearchUseCase,
            getCachedHotelSearchesUseCase
        )
    }

    @Test
    fun testMainSearchScreen() = runTest {

        composeTestRule.setContent {
            ShackleHotelBuddyTheme {
                Surface {
                    navController = TestNavHostController(LocalContext.current)
                    navController.navigatorProvider.addNavigator(ComposeNavigator())
                    MainSearchScreen(viewModel, navController)
                }
            }
        }

        // title text
        composeTestRule
            .onNodeWithText(activity.getString(R.string.select_guests_date_time))
            .assertIsDisplayed()

        // check in text
        composeTestRule
            .onNodeWithText(activity.getString(R.string.check_in_date))
            .assertIsDisplayed()

        // check out text
        composeTestRule
            .onNodeWithText(activity.getString(R.string.check_out_date))
            .assertIsDisplayed()

        // adults text
        composeTestRule
            .onNodeWithText(activity.getString(R.string.adults))
            .assertIsDisplayed()

        // children text
        composeTestRule
            .onNodeWithText(activity.getString(R.string.children))
            .assertIsDisplayed()

        // recent searches text
        composeTestRule
            .onNodeWithText(activity.getString(R.string.recent_searches))
            .assertIsDisplayed()

        // searches button
        composeTestRule
            .onNodeWithText(activity.getString(R.string.search))
            .assertIsDisplayed()

        // recent searches icon content description
        composeTestRule
            .onNodeWithContentDescription(activity.getString(R.string.icon_recent_search))
            .assertIsDisplayed()
    }

    @ExperimentalMaterial3Api
    @Test
    fun testHotelListScreen() = runTest {

        composeTestRule.setContent {
            ShackleHotelBuddyTheme {
                Surface {
                    navController = TestNavHostController(LocalContext.current)
                    navController.navigatorProvider.addNavigator(ComposeNavigator())
                    HotelListScreen(viewModel, navController)
                }
            }
        }

        // title text
        composeTestRule
            .onNodeWithText(activity.getString(R.string.search_results))
            .assertIsDisplayed()
    }
}

