package com.adrianczuczka.data.properties.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
internal object PropertiesModule {

    @Provides
    fun providePropertiesService(client: OkHttpClient): PropertiesService =
        Retrofit.Builder()
            .baseUrl("https://hotels4.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(PropertiesService::class.java)

    @Provides
    fun provideHttpClient(): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor { chain ->
            val request: Request = chain.request()
            val headers = request
                .headers()
                .newBuilder()
                .add(API_HEADER_KEY, API_HEADER_VALUE)
                .add(HOST_HEADER_KEY, HOST_HEADER_VALUE)
                .add("content-type", "application/json")
                .build()
            val newRequest = request.newBuilder().headers(headers).build()
            chain.proceed(newRequest)
        }
        return clientBuilder.build()
    }

    private const val API_HEADER_KEY = "X-RapidAPI-Key"

    /**
     *  This should not be saved within the code. It should be saved locally within a file such as
     *  local.properties. It is only added here to make testing this app easier
     */
    private const val API_HEADER_VALUE = "ecd51782c5msh6d33a0e41999c36p1aaadbjsn89d210a1a738"

    private const val HOST_HEADER_KEY = "X-RapidAPI-Host"
    private const val HOST_HEADER_VALUE = "hotels4.p.rapidapi.com"
}