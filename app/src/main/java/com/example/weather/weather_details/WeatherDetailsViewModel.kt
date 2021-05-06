package com.example.weather.weather_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.weather_details.repository.CurrentWeatherRepository
import com.example.weather.weather_details.retrofit.current.CurrentTemperature
import com.example.weather.weather_details.retrofit.current.CurrentWeatherProperty
import kotlinx.coroutines.*
import java.lang.Exception

private val currentWeatherRepository = CurrentWeatherRepository()

class WeatherDetailsViewModel : ViewModel() {

    private val viewModelJob = Job()
    val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val _currentTemperature = MutableLiveData<String>()
    val currentTemperature: LiveData<String>
        get() = _currentTemperature

    init {
       getCurrentWeather()

    }

    private fun getCurrentWeather() {
        viewModelScope.launch {
                try {
                    currentWeatherRepository.getCurrentTemperature()
                    _currentTemperature.value = currentWeatherRepository.currentTemperature
                } catch (e: Exception) {
                    e.printStackTrace()
                }

          }
        }

}