package com.example.weather.weather_details.retrofit.current_weather_data

import com.squareup.moshi.Json

data class CurrentTemperature(
    val temp: Double,
    @Json(name = "feels_like")
    val feelsLike: Double,
    @Json(name = "temp_min")
    val minTemp: Double,
    @Json(name = "temp_max")
    val maxTemp: Double,
    val pressure: Double,
    val humidity: Double
) {
    val tempString: String
        get() = temp.toString()

    val feelsLikeString: String
        get() = feelsLike.toString()

    val minTempString: String
        get() = minTemp.toString()

    val maxTempString: String
        get() = maxTemp.toString()

    val pressureString: String
        get() = pressure.toString()

    val humidityString: String
        get() = humidity.toString()
}