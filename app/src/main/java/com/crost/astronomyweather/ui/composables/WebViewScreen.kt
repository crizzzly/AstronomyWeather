package com.crost.astronomyweather.ui.composables

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

import com.crost.astronomyweather.utils.SERVER



@Composable
fun WebViewScreen() {
    // TODO: Consider optimizing performance by minimizing unnecessary WebView updates
    //  and avoiding excessive resource consumption.
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.setSupportZoom(true)
            }
        },
        update = { webView ->
            webView.loadUrl(SERVER)
        }
    )
}