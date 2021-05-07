package com.example.weather.utils

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.weather.R
import kotlin.math.round

const val BASE_IMG_URL: String = "http://openweathermap.org/img/wn/"
const val EXPANSION: String = "@2x.png"
@BindingAdapter("temperatureCelsiusBinding")
fun bindCelsiusString(textView: TextView, doubleTemperature: Double?) {
    doubleTemperature?.let {
        val integerTemperatureRounded = round(doubleTemperature).toInt()
        val temperatureString = integerTemperatureRounded.toString() + "\u2103"
        textView.text = temperatureString
    }
}

@BindingAdapter("weatherConditionsIconBinding")
fun bindImage(imageView: ImageView, imageSrc: String?) {
    imageSrc?.let {
        val imageUrl = BASE_IMG_URL + imageSrc + EXPANSION
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imageUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.placeholder_image))
            .into(imageView)
        Log.v("bind", "${imageUri}")
    }
}