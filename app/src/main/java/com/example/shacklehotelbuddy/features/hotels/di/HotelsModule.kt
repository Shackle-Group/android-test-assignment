package com.example.shacklehotelbuddy.features.hotels.di

import com.example.shacklehotelbuddy.features.hotels.api.HotelsApiRepository
import com.example.shacklehotelbuddy.features.hotels.api.IHotelsApiRepository
import com.example.shacklehotelbuddy.features.hotels.useCases.HotelsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HotelsModule {
    @Binds
    abstract fun bindHotelsApiRepository(hotelsApiRepository: HotelsApiRepository): IHotelsApiRepository
}