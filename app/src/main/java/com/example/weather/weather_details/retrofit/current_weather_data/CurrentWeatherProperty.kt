package com.example.weather.weather_details.retrofit.current_weather_data

import com.example.weather.weather_details.retrofit.current_weather_data.CurrentConditions
import com.example.weather.weather_details.retrofit.current_weather_data.CurrentTemperature
import com.squareup.moshi.Json

data class CurrentWeatherProperty(
    @Json(name = "weather")
    val currentConditions: Array<CurrentConditions>,
    @Json(name = "main")
    val currentTemperature: CurrentTemperature
) {
}