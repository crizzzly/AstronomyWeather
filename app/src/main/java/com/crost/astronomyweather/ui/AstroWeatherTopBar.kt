package com.crost.astronomyweather.ui

import android.app.Notification.Action
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.crost.astronomyweather.AstronomyWeatherApp
import com.crost.astronomyweather.ui.theme.ActionContentColor
import com.crost.astronomyweather.ui.theme.ForegroundTextColor
import com.crost.astronomyweather.ui.theme.appBarBackgroundGrey
import com.crost.astronomyweather.ui.theme.darkerRed
import com.crost.astronomyweather.ui.theme.lilac80

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AstronomyWeatherAppBar(){
    TopAppBar(
        title = { Text("Astronomy Weather") },
        colors = TopAppBarColors(
            containerColor = appBarBackgroundGrey,
            scrolledContainerColor = appBarBackgroundGrey,
            navigationIconContentColor = ForegroundTextColor,
            titleContentColor = ForegroundTextColor,
            actionIconContentColor = ActionContentColor
        )

//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer,
//            titleContentColor = MaterialTheme.colorScheme.primary,
//        )
    )

}