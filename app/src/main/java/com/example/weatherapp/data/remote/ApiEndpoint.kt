package com.example.weatherapp.data.remote

import com.example.weatherapp.data.model.WeatherData
import com.example.weatherapp.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiEndpoint {
    @GET(ApiDetails.FORECAST_ENDPOINT)
    suspend fun getWeatherForecastByCity(
        @Query("q")
        city: String,
        @Query("appid")
        appid: String = ApiDetails.API_KEY
    ): Response<WeatherResponse>

}