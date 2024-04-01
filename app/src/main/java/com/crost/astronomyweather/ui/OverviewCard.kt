package com.crost.astronomyweather.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crost.astronomyweather.ui.theme.Blue40
import com.crost.astronomyweather.ui.theme.DarkerBackgroundGrey
import com.crost.astronomyweather.ui.theme.DisabledContainerColor
import com.crost.astronomyweather.ui.theme.DisabledContentColor
import com.crost.astronomyweather.ui.theme.ForegroundTextColor
import com.crost.astronomyweather.ui.screens.main.DataPlotArea

const val ROUNDED_CORNER_SIZE = 10
const val FONT_SIZE = 30

const val PADDING_XS = 4
const val PADDING_S = 8
const val PADDING_M = 16
const val PADDING_L = 24


@Preview(showBackground = true,
widthDp = 300, heightDp = 400)
@Composable
fun OverviewCard() {
    Card(
        shape = RoundedCornerShape(ROUNDED_CORNER_SIZE.dp),
        elevation = CardDefaults.cardElevation(),
        colors = CardColors(
            containerColor = DarkerBackgroundGrey,
            contentColor = ForegroundTextColor,
            disabledContainerColor = DisabledContainerColor,
            disabledContentColor = DisabledContentColor
        ),
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.6f)
//            .defaultMinSize(minHeight = 400.dp, minWidth = 200.dp)
            .padding(PADDING_S.dp)
        ,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardTitle()
            CardContent()
        }
    }
}

@Composable
fun CardContent(){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Show Previous City In List
        IconButton(
            onClick = {/*TODO*/},
        ){
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowLeft,
                contentDescription = "show previous city in list")
        }
        DataPlotArea()

        IconButton(
            onClick = {/*TODO*/},
        ){
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = "show previous city in list")
        }

    }

}

@Composable
fun CardTitle(city: String = "Stuttgart"){
    val offset = Offset(2.0f, 3.0f)
    Text(text = city,
        fontSize = FONT_SIZE.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(0.dp, PADDING_M.dp),
        style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = FONT_SIZE.sp,
                shadow = Shadow(
                    color = Blue40, offset = offset, blurRadius = 3f
                )
            ),
//            color = darkerRed
    )
    HorizontalDivider()
}