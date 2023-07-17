package com.example.currentweatherdata.ui.temperature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currentweatherdata.models.network.WeatherResponse
import com.example.currentweatherdata.repository.WeatherRepository
import com.example.currentweatherdata.repository.WeatherRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TemperatureViewModel
@Inject constructor(private val repository: WeatherRepositoryImpl) : ViewModel() {

    private val apiKey = "97e0e9d2cdbe30acc28a54f5007f97ba"

    private val _weatherData = MutableLiveData<WeatherResponse>()
    val weatherData: LiveData<WeatherResponse> = _weatherData

    fun getWeatherInfo(location: String) {
        viewModelScope.launch {
            try {
                val result = repository.getCurrentWeather(location, apiKey)
                _weatherData.value = result
            } catch (e: Exception) {
                // Manejar el ERROR

            }
        }
    }
}
