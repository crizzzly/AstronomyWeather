package com.crost.astronomyweather.worker

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.crost.astronomyweather.MainViewModel


class MyWorkerFactory(
    private val viewModel: MainViewModel
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            FetchImageWorker::class.java.name -> {
                FetchImageWorker(appContext, workerParameters)
            }
            else -> null
        }
    }
}