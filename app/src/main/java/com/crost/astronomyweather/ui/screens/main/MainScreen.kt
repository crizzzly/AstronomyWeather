package com.crost.astronomyweather.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.crost.astronomyweather.ui.AstronomyWeatherAppBar
import com.crost.astronomyweather.ui.screens.imageslider.PreviewCustomImageSlider
import com.crost.astronomyweather.ui.theme.DarkerBackgroundGrey
import com.crost.astronomyweather.ui.theme.BackgroundGrey


@Preview(showBackground = true,
    backgroundColor = 0x404040)
@Composable
fun MainScreen(){
    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = DarkerBackgroundGrey,
        contentColor = BackgroundGrey,
        topBar = { AstronomyWeatherAppBar() },
        modifier = Modifier
            .fillMaxSize()
    ) { paddingVals ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingVals)
                .verticalScroll(state = scrollState)
                .background(BackgroundGrey)
//                .padding(paddingVals)


            , //MaterialTheme.colorScheme.background
        ){
            //OverviewCard()
            PreviewCustomImageSlider()
        }

    }
}