package com.hitrosttech.weatherupdate.domain.weather

import com.hitrosttech.weatherupdate.domain.weather.model.WeatherData

data class WeatherInfo(
	val weatherDataPerDay: Map<Int, List<WeatherData>>,
	val currentWeatherData: WeatherData?
)
