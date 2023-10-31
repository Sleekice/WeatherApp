package com.example.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("deg")
    val deg: Int? = 0,
    @SerializedName("gust")
    val gust: Double? = 0.0,
    @SerializedName("speed")
    val speed: Double? = 0.0
)

