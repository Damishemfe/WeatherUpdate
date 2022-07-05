package com.hitrosttech.weatherupdate.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.hitrosttech.weatherupdate.data.mappers.toWeatherInfo
import com.hitrosttech.weatherupdate.data.remote.WeatherApi
import com.hitrosttech.weatherupdate.domain.repository.WeatherRepository
import com.hitrosttech.weatherupdate.domain.util.Resource
import com.hitrosttech.weatherupdate.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
	private val api: WeatherApi
) : WeatherRepository {
	@RequiresApi(Build.VERSION_CODES.O)
	override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
		return try {
			Resource.Success(
				data = api.getWeatherData(
					lat = lat,
					long = long
				).toWeatherInfo()
			)
		} catch (e: Exception) {
			e.printStackTrace()
			Resource.Error(e.message ?: "An unexpected error occurred. Please try again")
		}
	}
}