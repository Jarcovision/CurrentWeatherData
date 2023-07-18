package com.example.currentweatherdata.network

import com.example.currentweatherdata.models.network.WeatherResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

// TODO sacar response de retrofit
interface WeatherInterface {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") location: String,
        @Query("appid") apiKey: String): Response<WeatherResponse>
}


