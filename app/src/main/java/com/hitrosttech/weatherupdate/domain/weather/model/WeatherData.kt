package com.hitrosttech.weatherupdate.domain.weather.model

import com.hitrosttech.weatherupdate.domain.weather.WeatherType
import java.time.LocalDateTime

data class WeatherData(
	val time: LocalDateTime,
	val temperatureCelsius: Double,
	val pressure: Double,
	val windSpeed: Double,
	val humidity: Double,
	val weatherType: WeatherType
)
