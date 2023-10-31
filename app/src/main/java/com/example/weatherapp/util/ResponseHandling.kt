package com.example.weatherapp.util

sealed class ResponseHandling {

    object Loading: ResponseHandling()

    class Success<T>(val result: T): ResponseHandling()

    class Error(val error: String = "Something went wrong!") : ResponseHandling()
}
