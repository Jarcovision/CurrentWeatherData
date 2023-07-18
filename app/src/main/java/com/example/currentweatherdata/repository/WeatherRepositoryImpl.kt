package com.example.currentweatherdata.repository

import com.example.currentweatherdata.models.network.WeatherResponse
import com.example.currentweatherdata.network.WeatherInterface
import javax.inject.Inject

// TODO: Falta el mapper
class WeatherRepositoryImpl
@Inject constructor(
    private val weatherInterface: WeatherInterface
) : WeatherRepository {

    // TODO: Utilizar flow
    // TODO: Poner aquí la api key
    override suspend fun getCurrentWeather(location: String, apiKey: String): WeatherResponse {
        val response = weatherInterface.getCurrentWeather(location, apiKey)
        if (response.isSuccessful) {
            return response.body() ?: throw Exception("Empty response body")
        } else {
            throw Exception("API request failed with code ${response.code()}")
        }
    }
}

