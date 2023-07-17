package com.example.currentweatherdata.di

import com.example.currentweatherdata.network.WeatherInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val REQUEST_TIMEOUT: Long = 120000

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(REQUEST_TIMEOUT, TimeUnit.MILLISECONDS)
        httpClient.addInterceptor(logging)
        return httpClient.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    @Singleton
    @Provides
    fun provideWeatherInterface(
        retrofit: Retrofit
    ) = retrofit.create(WeatherInterface::class.java)

}