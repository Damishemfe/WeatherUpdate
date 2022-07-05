package com.hitrosttech.weatherupdate.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hitrosttech.weatherupdate.presentation.ui.theme.DarkBlue
import com.hitrosttech.weatherupdate.presentation.ui.theme.DeepBlue
import com.hitrosttech.weatherupdate.presentation.ui.theme.WeatherUpdateTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.jar.Manifest

@RequiresApi(Build.VERSION_CODES.O)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	
	private val viewModel: WeatherViewModel by viewModels()
	private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		permissionLauncher = registerForActivityResult(
			ActivityResultContracts.RequestMultiplePermissions()
		) {
			viewModel.loadWeatherInfo()
		}
		permissionLauncher.launch(arrayOf(
			android.Manifest.permission.ACCESS_FINE_LOCATION,
			android.Manifest.permission.ACCESS_COARSE_LOCATION,
			android.Manifest.permission.INTERNET
		))
		setContent {
			WeatherUpdateTheme {
				
				Box(modifier = Modifier.fillMaxSize()) {
					Column(modifier = Modifier
						.fillMaxSize()
						.background(DarkBlue)) {
						WeatherCard(state = viewModel.state, backgroundColor = DeepBlue)
						Spacer(modifier = Modifier.height(16.dp))
						WeatherForecast(state = viewModel.state)
					}
					
					if (viewModel.state.isLoading) {
						CircularProgressIndicator(
							modifier = Modifier.align(Alignment.Center)
						)
					}
					
					viewModel.state.error?.let { error ->
						Text(
							text = error,
							color = Color.Red,
							textAlign = TextAlign.Center,
							modifier = Modifier.align(Alignment.Center)
						)
					}
				}
			}
		}
	}
}
