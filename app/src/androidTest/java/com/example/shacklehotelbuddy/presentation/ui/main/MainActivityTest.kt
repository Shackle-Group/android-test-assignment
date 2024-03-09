package com.example.shacklehotelbuddy.presentation.ui.main

import com.example.shacklehotelbuddy.domain.usecase.GetCachedHotelSearchesUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject

@HiltAndroidTest
class MainActivityTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var getCachedHotelSearchesUseCase: GetCachedHotelSearchesUseCase

    @Before
    fun init() {
        hiltRule.inject()
    }
}
