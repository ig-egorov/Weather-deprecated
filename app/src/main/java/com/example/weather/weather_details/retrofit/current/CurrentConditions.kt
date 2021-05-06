package com.example.weather.weather_details.retrofit.current

data class CurrentConditions(
    val id: String,
    val main: String,
    val description: String,
    val icon: String
) {
}