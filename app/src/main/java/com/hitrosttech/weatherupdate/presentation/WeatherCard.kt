package com.hitrosttech.weatherupdate.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hitrosttech.weatherupdate.R
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherCard(
	state: WeatherState,
	backgroundColor: Color,
	modifier: Modifier = Modifier
) {
	state.weatherInfo?.currentWeatherData?.let { data ->
		
		Card(
			backgroundColor = backgroundColor,
			shape = RoundedCornerShape(12.dp),
			modifier = modifier.padding(18.dp)
		) {
			Column(
				modifier = Modifier
					.fillMaxWidth()
					.padding(18.dp),
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text(
					text = "Today ${
						data.time.format(
							DateTimeFormatter.ofPattern("HH:mm")
						)
					}",
					modifier = Modifier.align(Alignment.End),
					color = Color.White
				)
				
				Spacer(modifier = Modifier.height(18.dp))
				
				Image(
					painter = painterResource(id = data.weatherType.iconRes),
					contentDescription = null,
					modifier = Modifier.width(200.dp)
				)
				
				Spacer(modifier = Modifier.height(18.dp))
				
				Text(
					text = "${data.temperatureCelsius}°C",
					fontSize = 55.sp,
					fontWeight = FontWeight.Black,
					color = Color.White
				)
				
				Spacer(modifier = Modifier.height(15.dp))
				
				Text(
					text = "${data.weatherType.weatherDesc}",
					fontSize = 20.sp,
					fontWeight = FontWeight.Normal,
					color = Color.White
				)
				
				Spacer(modifier = Modifier.height(34.dp))
				
				Row(
					modifier = Modifier.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceAround
				) {
					WeatherDataInfographics(
						value = data.pressure.roundToInt(),
						unit = "hpa",
						icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
						iconTint = Color.White,
						textStyle = TextStyle(color = Color.White)
					)
					WeatherDataInfographics(
						value = data.humidity.roundToInt(),
						unit = "%",
						icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
						iconTint = Color.Cyan,
						textStyle = TextStyle(color = Color.Cyan)
					)
					WeatherDataInfographics(
						value = data.windSpeed.roundToInt(),
						unit = "km/h",
						icon = ImageVector.vectorResource(id = R.drawable.ic_wind),
						iconTint = Color.Yellow,
						textStyle = TextStyle(color = Color.Yellow)
					)
				}
			}
		}
	}
	
}