package com.crost.astronomyweather.ui

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import java.io.File


@Composable
fun DisplayImageFromStorage() {
    val context = LocalContext.current
    val cacheDir = context.cacheDir
    val file = File(cacheDir, "clouds_image.png")

    val imageBitmap = BitmapFactory.decodeFile(file.absolutePath)?.asImageBitmap()

    if (imageBitmap != null) {
        Image(bitmap = imageBitmap, contentDescription = null)
    } else {
        // Handle case when image cannot be loaded
    }
}