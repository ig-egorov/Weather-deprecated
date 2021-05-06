package com.example.weather.weather_details.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weather.weather_details.retrofit.WeatherApi
import com.example.weather.weather_details.retrofit.current.CurrentTemperature
import com.example.weather.weather_details.retrofit.current.CurrentWeatherProperty
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrentWeatherRepository {

    var currentTemperature: String = "NONE"

    suspend fun getCurrentTemperature() {
        var currentWeatherProperty: CurrentWeatherProperty
        try {
            currentWeatherProperty = WeatherApi.retrofitService.getCurrentWeather("Moscow")
            currentTemperature = currentWeatherProperty.currentTemperature.tempString
            Log.v("CurrentWeatherRepo", "Temp ${currentTemperature}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}