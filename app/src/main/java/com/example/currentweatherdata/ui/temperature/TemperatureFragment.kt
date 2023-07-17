package com.example.currentweatherdata.ui.temperature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.currentweatherdata.databinding.FragmentTemperatureBinding
import com.example.currentweatherdata.models.network.WeatherResponse

class TemperatureFragment : Fragment() {

    private var _binding: FragmentTemperatureBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TemperatureViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTemperatureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.weatherData.observe(viewLifecycleOwner, this::updateWeather)

        viewModel.getWeatherInfo("Cupertino")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateWeather(weatherResponse: WeatherResponse) {
        val cityName = weatherResponse.cityName
        val temperature = weatherResponse.temp
        val description = weatherResponse.description
        val tempMax = weatherResponse.tempMax
        val tempMin = weatherResponse.tempMin

        binding.cityName.text = cityName
        binding.currentTemperature.text = temperature.toString()
        binding.weatherDescription.text = description
        binding.max.text = tempMax.toString()
        binding.min.text = tempMin.toString()
    }
}

