package com.example.currentweatherdata.repository

import com.example.currentweatherdata.models.network.WeatherResponse
import com.example.currentweatherdata.network.WeatherInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


interface WeatherRepository {
    suspend fun getCurrentWeather(location: String, apiKey: String): WeatherResponse
}

