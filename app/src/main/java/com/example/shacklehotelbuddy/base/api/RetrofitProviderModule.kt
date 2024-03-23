package com.example.shacklehotelbuddy.base.api

import android.app.Application
import com.example.shacklehotelbuddy.features.hotels.api.HotelsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

const val BASE_API = "https://hotels4.p.rapidapi.com"
private const val TIME_OUT_IN_SECONDS = 30
private const val CACHE_SIZE = 32 * 1024 * 1024L // 32 MB.

@Module
@InstallIn(SingletonComponent::class)
class RetrofitProviderModule {
    @Provides
    @Singleton
    fun provideDefaultOkHttpClient(
        application: Application,
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(TIME_OUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
        .writeTimeout(TIME_OUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
        .readTimeout(TIME_OUT_IN_SECONDS.toLong(), TimeUnit.SECONDS)
        .cache(Cache(application.cacheDir, CACHE_SIZE))
        .build()

    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_API)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideSearchApiService(retrofit: Retrofit): HotelsApiService =
        retrofit.create(HotelsApiService::class.java)
}