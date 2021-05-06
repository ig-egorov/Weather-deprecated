package com.example.weather.weather_details.retrofit.current

import com.squareup.moshi.Json

data class CurrentWeatherProperty(
    @Json(name = "weather")
    val currentConditions: Array<CurrentConditions>,
    @Json(name = "main")
    val currentTemperature: CurrentTemperature
) {
}