package com.example.shacklehotelbuddy.features.search.di

import com.example.shacklehotelbuddy.features.search.db.ISearchParametersDbRepository
import com.example.shacklehotelbuddy.features.search.db.SearchParametersDbRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class SearchModule {
    @Binds
    abstract fun bindSearchParametersDbRepository(
        hotelsApiRepository: SearchParametersDbRepository): ISearchParametersDbRepository
}