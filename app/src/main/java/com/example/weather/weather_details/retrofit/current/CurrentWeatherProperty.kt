package com.example.weather.weather_details.retrofit

import com.squareup.moshi.Json

data class CurrentWeatherProperty(
    @Json(name = "weather")
    val currentConditions: Array<CurrentConditions>,
    
    val currentTemperature: CurrentTemperature
) {
}