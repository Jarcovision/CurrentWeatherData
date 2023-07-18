package com.example.currentweatherdata.models.network

import com.google.gson.annotations.SerializedName

/**
 * TODO: Falta el icono. Borrar código comnetado.
 * TODO: Obtener todo el response.
 */
data class WeatherResponse(
    @SerializedName("name") val cityName: String?,
    @SerializedName("temp") val temp: Int? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("temp_max") val tempMax: Int? = null, // En la imagen está primero la temperatura máxima
    @SerializedName("temp_min") val tempMin: Int? = null,
    )

/*val weatherResponse: WeatherResponse? = response.body()

weatherResponse?.let {
    val cityName = weatherResponse.cityName
    val temp = weatherResponse.temp
    val description = weatherResponse.description
    val tempMax = weatherResponse.tempMax
    val tempMin = weatherResponse.tempMin
}*/
