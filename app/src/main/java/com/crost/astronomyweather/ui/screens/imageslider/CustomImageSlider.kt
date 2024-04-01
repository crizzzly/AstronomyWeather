package com.crost.astronomyweather.ui.screens.imageslider

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.crost.astronomyweather.R
import com.crost.astronomyweather.ui.PADDING_M
import com.crost.astronomyweather.ui.PADDING_S
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

// https://developer.android.com/reference/kotlin/androidx/compose/foundation/pager/package-summary

@Preview
@Composable
fun PreviewCustomImageSlider(){
    val sliderList = remember {
        mutableListOf(
            "https://www.gstatic.com/webp/gallery/1.webp",
            "https://www.gstatic.com/webp/gallery/2.webp",
            "https://www.gstatic.com/webp/gallery/3.webp",
            "https://www.gstatic.com/webp/gallery/4.webp",
            "https://www.gstatic.com/webp/gallery/5.webp",
        )
    }
    CustomSlider(
        sliderList = sliderList,
//        modifier = Modifier.
    )
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CustomSlider(
    modifier: Modifier = Modifier,
    sliderList: MutableList<String>,
    backwardIcon: ImageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
    forwardIcon: ImageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
    dotsActiveColor: Color = Color.DarkGray,
    dotsInActiveColor: Color = Color.LightGray,
    dotsSize: Dp = 10.dp,
    pagerPaddingValues: PaddingValues = PaddingValues(horizontal = 30.dp),
    imageCornerRadius: Dp = 16.dp,
    imageHeight: Dp = 400.dp,
) {
    val pagerState = rememberPagerState(
        pageCount = { sliderList.size },
        initialPage = 0,
    )
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {

            IconButton( // Left Arrow
                enabled = pagerState.canScrollBackward,
                onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage - 1) }
            }) {
                Icon(
                    imageVector = backwardIcon,
                    contentDescription = "backward swipe"

                )
            }


            HorizontalPager(
                state = pagerState,
                contentPadding = pagerPaddingValues,
                modifier = modifier.weight(1f),
                pageSpacing = -30.dp
            ) { page ->
                val pageOffset =
                    (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

                val scaleXFactor = 0.9f + (1f - 0.75f) * (1f - pageOffset.absoluteValue)
                val scaleYFactor = 0.75f + (1f - 0.75f) * (1f - pageOffset.absoluteValue)


                Box(modifier = modifier
                    .graphicsLayer {
                        scaleX = scaleXFactor
                        scaleY = scaleYFactor
                    }
                    .alpha(
                        scaleXFactor.coerceIn(0f, 1f)
                    )
                    .padding(PADDING_S.dp)
                    .clip(RoundedCornerShape(imageCornerRadius))) {
                    Column(

                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current).scale(Scale.FIT)
                                .crossfade(true).data(sliderList[page]).build(),
                            contentDescription = "Image",
                            contentScale = ContentScale.Crop,
                            placeholder = painterResource(id = R.drawable.heubach_0),
                            modifier = modifier
                                .width(imageHeight)
                                .alpha(if (pagerState.currentPage == page) 1.0f else 0.5f)
//                                .align(Alignment.TopCenter)
                        )
                    }
                }
            }


            IconButton(  // Right Arrow
                enabled = pagerState.canScrollForward,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                }) {
                Icon(
                    imageVector = forwardIcon,
                    contentDescription = "forward swipe"
                )
            }
        }
        Row(   // DOTS
            modifier
                .height(50.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            repeat(sliderList.size) {
                val color = if (pagerState.currentPage == it) dotsActiveColor else dotsInActiveColor
                Box(modifier = modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .size(dotsSize)
                    .background(color)
                    .clickable {
                        scope.launch {
                            pagerState.animateScrollToPage(it)
                        }
                    })
            }
        }

        HorizontalDivider(
            thickness = 1.dp,
            modifier = Modifier
                .padding(PADDING_S.dp, PADDING_M.dp)
//                            .align(Alignment.Center)
        )

        Text(text= "Hallob Bla bla")
    }
}