package com.crost.astronomyweather.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.crost.astronomyweather.R
import com.crost.astronomyweather.ui.PADDING_S
import com.crost.astronomyweather.ui.PADDING_XS


@Composable
fun DataPlotArea() {
    var buttonUpEnabled = remember { mutableStateOf(false) }
    var buttonDownEnabled = remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(PADDING_XS.dp, PADDING_S.dp)
            .fillMaxSize(.75f)
    ) {
        val btnPad = PADDING_S.dp
        IconButton(
            enabled = buttonUpEnabled.value,
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowUp,
                contentDescription = "show previous plot")
        }
        Image(
            painter = painterResource(id = R.drawable.heubach_0),
            contentDescription ="WeatherDataPlot",
            modifier = Modifier.fillMaxSize()
        )

        IconButton(
            enabled = buttonDownEnabled.value,
            onClick = { /*TODO*/ }

        ) {
            Image(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = "show next plot")
        }

    }
}