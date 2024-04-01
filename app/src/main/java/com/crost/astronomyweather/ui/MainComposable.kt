package com.crost.astronomyweather.ui

import android.os.Build
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.crost.astronomyweather.ui.screens.main.MainScreen
import com.crost.aurorabzalarm.utils.PermissionManager


@Composable
fun MainComposable(
    permissionManager: PermissionManager,
    permissionLauncher: ActivityResultLauncher<Array<String>>
) {
    val context = LocalContext.current
    val permissionState by permissionManager.permissionState.collectAsState()

    if (! permissionState) {
        if (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                permissionManager.hasPermission(context)
            } else {
                TODO("VERSION.SDK_INT < TIRAMISU")
            }
        ) {
            permissionManager.onPermissionGranted()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                permissionManager.requestPermission(context, permissionLauncher)
            }
        }
    }
    MainScreen()
}