package com.hitrosttech.weatherupdate.data.remote

import com.hitrosttech.weatherupdate.data.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
	
	@GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
	suspend fun getWeatherData(
		@Query("latitude") lat: Double,
		@Query("longitude") long: Double
	): WeatherDto
}