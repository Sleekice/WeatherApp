package com.example.weatherapp.data.model

import com.google.gson.annotations.SerializedName


data class WeatherData(

    @SerializedName("clouds")
    val clouds: Clouds? = Clouds(),
    @SerializedName("dt")
    val dt: Int? = 0,
    @SerializedName("dt_txt")
    val dtTxt: String? = "",
    @SerializedName("main")
    val main: MainData? = MainData(),
    @SerializedName("pop")
    val pop: Double? = 0.0,
    @SerializedName("rain")
    val rain: Rain? = Rain(),
    @SerializedName("sys")
    val sys: Sys? = Sys(),
    @SerializedName("visibility")
    val visibility: Int? = 0,
    @SerializedName("weather")
    val weather: List<WeatherDescription?>? = listOf(),
    @SerializedName("wind")
    val wind: Wind? = Wind()
)
