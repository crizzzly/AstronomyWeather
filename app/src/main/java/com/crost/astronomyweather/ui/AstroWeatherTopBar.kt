package com.crost.astronomyweather.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.crost.astronomyweather.AstronomyWeatherApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AstronomyWeatherAppBar(){
    TopAppBar(
        title = { Text("Astronomy Weather") })
}