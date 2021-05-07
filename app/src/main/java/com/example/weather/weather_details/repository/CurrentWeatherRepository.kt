package com.example.weather.weather_details.repository

import android.util.Log
import com.example.weather.weather_details.retrofit.WeatherApi
import com.example.weather.weather_details.retrofit.current_weather_data.CurrentWeatherProperty

const val TAG = "CurrentWeatherRepo"

class CurrentWeatherRepository {

    lateinit var currentWeatherProperty: CurrentWeatherProperty
    var currentTemperature: Double = 0.0
    var currentConditionsIcon: String = "Cond NONE"

    suspend fun getCurrentProperty() {
        try {
            currentWeatherProperty = WeatherApi.retrofitService.getCurrentWeather("Moscow")
            currentTemperature = currentWeatherProperty.currentTemperature.temp
            currentConditionsIcon = currentWeatherProperty.currentConditions[0].icon
            Log.v(TAG, "temp: ${currentTemperature}, icon: ${currentConditionsIcon}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}