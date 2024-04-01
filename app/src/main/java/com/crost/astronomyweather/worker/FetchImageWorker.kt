package com.crost.astronomyweather.worker

import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class FetchImageWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    private val client = OkHttpClient()
    private val ctx = context

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        Log.d("FetchImageWorker", "Fetching image")
        try {
            val request = Request.Builder()
                .url("http://192.168.2.30:5000/get_cloud_image")
                .build()

            val response = client.newCall(request).execute()
            if (!response.isSuccessful) {
                return@withContext Result.failure()
            }

            val inputStream: InputStream = response.body.byteStream() ?: return@withContext Result.failure()
            // Save the image to local storage or pass it to UI
            saveImageToStorage(inputStream, ctx)

            Result.success()
        } catch (e: Exception) {
            Log.e("FetchImageWorker", "Error fetching image: ${e.message}", e)
            Result.failure()
        }
    }

    private fun saveImageToStorage(imageInputStream: InputStream, context: Context) {
        val cacheDir = context.cacheDir
        val file = File(cacheDir, "clouds_image.png")

        val inputStream = ByteArrayInputStream(imageInputStream.readBytes())
        inputStream.use { input ->
            file.outputStream().use { output ->
                input.copyTo(output)
            }
        }
        imageInputStream.close()
    }
}
