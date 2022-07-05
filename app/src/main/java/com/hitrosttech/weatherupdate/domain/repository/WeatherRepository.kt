package com.hitrosttech.weatherupdate.domain.repository

import com.hitrosttech.weatherupdate.domain.util.Resource
import com.hitrosttech.weatherupdate.domain.weather.WeatherInfo

interface WeatherRepository {
	suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}