package com.example.weather.weather_details.retrofit.current_weather_data

import com.squareup.moshi.Json

data class CurrentConditions(
    val id: String,
    val main: String,
    val description: String,
    val icon: String
) {
}