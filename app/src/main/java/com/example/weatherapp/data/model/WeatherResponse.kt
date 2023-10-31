package com.example.weatherapp.data.model

import com.example.weatherapp.data.model.WeatherData
import com.google.gson.annotations.SerializedName


data class WeatherResponse(
    @SerializedName("city")
    val city: City? = City(),
    @SerializedName("cnt")
    val cnt: Int? = 0,
    @SerializedName("cod")
    val cod: String? = "",
    @SerializedName("list")
    val list: List<WeatherData>? = null,
    @SerializedName("message")
    val message: Int? = 0
)


