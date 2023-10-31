package com.example.weatherapp.data.model

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("3h")
    val h: Double? = 0.0
)