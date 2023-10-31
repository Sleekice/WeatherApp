package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.WeatherResponse
import retrofit2.Response

interface Repository {
    suspend fun getWeatherForecastByCity(city: String): Response<WeatherResponse>

}


