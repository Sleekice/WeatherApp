package com.example.weatherapp.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.data.model.WeatherData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherDetails(
    weatherViewModel: WeatherViewModel,

    ) {
    val weatherData by weatherViewModel.weatherData.collectAsState()

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val current = LocalDateTime.now().format(formatter)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            // City name
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Weather Icon",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "${weatherData.city?.name}",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp),
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))
            // Date
            Text(

                text = "Date: ${current}",
                style = TextStyle(fontSize = 16.sp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 36.sp)) {
                        append("Temperature: ")
                    }
                    val new =
                        weatherData?.list?.firstOrNull() // Get the first (current) weather data or null
                    val currentTemperature = new?.main?.temp // Extract the temperature
                    append(currentTemperature?.let { "$it°k" } ?: "N/A")
                },
                textAlign = TextAlign.Center,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 36.sp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            // Divider

            Divider(modifier = Modifier.padding(horizontal = 5.dp))
            Spacer(modifier = Modifier.height(10.dp))


/**            Row(modifier = Modifier.weight(1f)) {
//                LazyColumn {
//
//                    items(weatherData?.list?.take(1) ?: emptyList()) { weatherItem ->
//                        // Display the current temperature
//                        val currentTemperature = weatherItem.main?.temp
//                        Text(text = "Current Temp: $currentTemperature°k")
//
//
//                        val currentHumidity = weatherItem.main?.humidity
//                        Text(text = "Humidity: $currentHumidity%")
//
//
//                        // Add more fields in a similar manner
//                        val feelsLike = weatherItem.main?.feelsLike
//                        Text(text = "Feels Like: ${feelsLike}°k")
//
//
//
//                        val pressure = weatherItem.main?.pressure
//                        Text(text = "Pressure: ${pressure} hPa")
//
//
//                    }
//                }
//
//                Row(modifier = Modifier.weight(1f)) {
//                    LazyColumn {
//                        items(weatherData?.list?.take(1) ?: emptyList()) { weatherItem ->
//                            val seaLevel = weatherItem.main?.seaLevel
//                            Text(text = "Sea Level: ${seaLevel} hPa")
//
//                            val grndLevel = weatherItem.main?.grndLevel
//                            Text(text = "Ground Level: ${grndLevel} hPa")
//
//                            val tempMax = weatherItem.main?.tempMax
//                            Text(text = "Max Temp: ${tempMax}°k")
//
//                            val tempMin = weatherItem.main?.tempMin
//                            Text(text = "Min Temp: ${tempMin}°k")
//
**/


            Row {
                // Left Column
                Column(modifier = Modifier.weight(1f).padding(end = 4.dp)) {
                    LazyColumn {
                        items(weatherData?.list?.take(1) ?: emptyList()) { weatherItem ->
                            // Display the current temperature
                            val currentTemperature = weatherItem.main?.temp
                            Text(text = "Current Temp: $currentTemperature°k")

                            val currentHumidity = weatherItem.main?.humidity
                            Text(text = "Humidity: $currentHumidity%")

                            // Add more fields in a similar manner
                            val feelsLike = weatherItem.main?.feelsLike
                            Text(text = "Feels Like: ${feelsLike}°k")

                            val pressure = weatherItem.main?.pressure
                            Text(text = "Pressure: ${pressure} hPa")
                        }
                    }
                }

                // Divider
                Divider(
                    modifier = Modifier.width(1.dp)
                                .height(20.dp)
                                .padding(all = 2.dp)
                        .width(3.dp)
                                .align(Alignment.CenterVertically),

                    color = Color.Green // You can adjust the color
                )

                // Right Column
                Column(modifier = Modifier.weight(1f).padding(start = 4.dp)) {
                    LazyColumn {
                        items(weatherData?.list?.take(1) ?: emptyList()) { weatherItem ->
                            val seaLevel = weatherItem.main?.seaLevel
                            Text(text = "Sea Level: ${seaLevel} hPa")

                            val grndLevel = weatherItem.main?.grndLevel
                            Text(text = "Ground Level: ${grndLevel} hPa")

                            val tempMax = weatherItem.main?.tempMax
                            Text(text = "Max Temp: ${tempMax}°k")

                            val tempMin = weatherItem.main?.tempMin
                            Text(text = "Min Temp: ${tempMin}°k")
                        }
                    }
                }
            }

        }
    }





}
    @Composable
    fun WeatherInfo(label: String, value: String) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(text = label, fontWeight = FontWeight.Bold)
            Text(text = value)
        }
    }


