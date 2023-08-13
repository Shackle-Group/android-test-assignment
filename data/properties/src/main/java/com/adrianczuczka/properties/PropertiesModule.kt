package com.adrianczuczka.properties

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
            .baseUrl("https://rapidapi.com/apidojo/api/hotels4/")
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
    private const val API_HEADER_VALUE = "cc72f136a8msh018f48d73a78137p175bf4jsn7a5565edbf53"
}