package com.example.weatherapp.data.remote


    //https://api.openweathermap.org/data/2.5/weather?q=London,uk&appid=fafdc6533ef599c278770bf599914755

    //http://api.openweathermap.org/data/2.5/forecast?lat=44.34&lon=10.99&appid=bbb4ddd180567d73e8edfceb807b7a59

    object ApiDetails {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

        const val FORECAST_ENDPOINT = "forecast?"

        const val API_KEY = "bbb4ddd180567d73e8edfceb807b7a59" // Make sure to enclose the API key in double quotes.
    }
