package com.example.currentweatherdata.repository

import com.example.currentweatherdata.models.network.WeatherResponse
import com.example.currentweatherdata.network.WeatherInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

class WeatherRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val weatherInterface: WeatherInterface = retrofit.create(WeatherInterface::class.java)

    suspend fun getCurrentWeather(location: String, apiKey: String): WeatherResponse {
        val response = weatherInterface.getCurrentWeather(location, apiKey)
        if (response.isSuccessful) {
            return response.body() ?: throw Exception("Empty response body")
        } else {
            throw Exception("API request failed with code ${response.code()}")
        }

    }

}

