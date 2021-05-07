package com.example.weather.weather_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.weather_details.repository.CurrentWeatherRepository
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

    private val _currentTemperature = MutableLiveData<Double>()
    val currentTemperature: LiveData<Double>
        get() = _currentTemperature

    private val _currentConditionsIcon = MutableLiveData<String>()
    val currentConditionsIcon: LiveData<String>
        get() = _currentConditionsIcon

    init {
       getCurrentWeather()
    }

    private fun getCurrentWeather() {
        viewModelScope.launch {
                try {
                    currentWeatherRepository.getCurrentProperty()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            _currentTemperature.value = currentWeatherRepository.currentTemperature
            _currentConditionsIcon.value = currentWeatherRepository.currentConditionsIcon
          }
        }

}