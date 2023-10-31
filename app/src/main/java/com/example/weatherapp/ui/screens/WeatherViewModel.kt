package com.example.weatherapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _weatherData = MutableStateFlow<WeatherResponse>(WeatherResponse())
    val weatherData: StateFlow<WeatherResponse> = _weatherData


    fun fetchWeatherByCity(city: String) {
        viewModelScope.launch {
            val response = repository.getWeatherForecastByCity(city)
            if(response.isSuccessful)
                _weatherData.value = (response.body() ?: WeatherResponse())
        }
    }

    fun fetchWeatherBySearch(city: String){}

}