package com.crost.astronomyweather

import android.app.Application
import androidx.work.Configuration
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.crost.astronomyweather.worker.FetchImageWorker
import com.crost.astronomyweather.worker.MyWorkerFactory
import java.util.concurrent.TimeUnit


class AstronomyWeatherApp() : Application(), Configuration.Provider {
    private lateinit var mainViewModel:  MainViewModel

    override val workManagerConfiguration: Configuration
        get() =  Configuration.Builder()
            .setWorkerFactory(MyWorkerFactory(mainViewModel))
            .build()

    override fun onCreate() {
        super.onCreate()
        mainViewModel = MainViewModel()


        startImageWorker()
    }

    private fun startImageWorker() {
        WorkManager.initialize(this, workManagerConfiguration)
        val workManager = WorkManager.getInstance(this)
        val parsingWorkRequest =
            PeriodicWorkRequestBuilder<FetchImageWorker>(
                1, TimeUnit.HOURS
            )
                .addTag("FetchImageWorker")
                .setConstraints(Constraints(NetworkType.CONNECTED))
                .build()

        workManager.enqueue(parsingWorkRequest)
    }
}
