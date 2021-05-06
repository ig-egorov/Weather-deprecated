package com.example.weather.weather_details.retrofit

import com.example.weather.weather_details.retrofit.current.CurrentWeatherProperty
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
private const val API_KEY = "1594502c127ad840ab77f36f608636bd"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface WeatherDetailsApi {
    @GET("weather")
    suspend fun getCurrentWeather(@Query("q") city: String,
                                  @Query("units") units: String = "metric",
                                  @Query("appid") apiKey: String = API_KEY): CurrentWeatherProperty
}

object WeatherApi {
    val retrofitService : WeatherDetailsApi by lazy {
        retrofit.create(WeatherDetailsApi::class.java)
    }
}