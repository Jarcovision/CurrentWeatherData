package com.example.currentweatherdata.di

import com.example.currentweatherdata.repository.WeatherRepository
import com.example.currentweatherdata.repository.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CurrentWeatherDataRepositoryModule {

    @Binds
     abstract fun bindWeatherRepository(
        impl: WeatherRepositoryImpl
    ): WeatherRepository
}