package com.hitrosttech.weatherupdate.presentation

import com.hitrosttech.weatherupdate.domain.weather.WeatherInfo

data class WeatherState(
	val weatherInfo: WeatherInfo? = null,
	val isLoading: Boolean = false,
	val error: String? = null
)