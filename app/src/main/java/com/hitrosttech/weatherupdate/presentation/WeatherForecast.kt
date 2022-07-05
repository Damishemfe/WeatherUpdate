package com.hitrosttech.weatherupdate.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherForecast(
	state: WeatherState,
	modifier: Modifier = Modifier
) {
	
	state.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
		Column(
			modifier = modifier
				.fillMaxWidth()
				.padding(horizontal = 18.dp)
		) {
			Text(
				text = "Today",
				fontSize = 22.sp,
				fontWeight = FontWeight.Bold,
				color = Color.White
			)
			
			Spacer(modifier = Modifier.height(16.dp))
			
			
			LazyRow(content = {
				items(data) { weatherData ->
					HourlyWeatherDisplay(
						weatherData = weatherData,
						modifier = Modifier
							.height(100.dp)
							.padding(horizontal = 16.dp)
					)
				}
			})
		}
	}
}