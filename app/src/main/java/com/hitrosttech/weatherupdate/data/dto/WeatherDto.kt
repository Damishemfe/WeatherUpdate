package com.hitrosttech.weatherupdate.data.dto

import com.squareup.moshi.Json

data class WeatherDto(
	@field:Json(name = "hourly")
	val weatherData: WeatherDataDto
)
