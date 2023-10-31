package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.remote.ApiEndpoint
import retrofit2.Response
import javax.inject.Inject


class RepositoryImplementation @Inject constructor(
    private val service: ApiEndpoint
) : Repository {
    override suspend fun getWeatherForecastByCity(city: String): Response<WeatherResponse> {
        return service.getWeatherForecastByCity(city)

    }


}



