package jiglionero.android.app.putonpompom.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class WeatherWorker(context: Context, workerParams: WorkerParameters) : Worker(context,
    workerParams
) {

    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {
        val cityName = inputData.getString("cityName")
        val appId = inputData.getString("appId")
        val weatherApi: OpenWeatherApi = inputData.keyValueMap["api"] as OpenWeatherApi

        return if (cityName != null && appId != null) {
            val data = Data.Builder()
                .put("response", weatherApi.getCurrentWeather(cityName, appId).execute().body())
                .build()
            Result.success(data)
        } else{
            Result.failure()
        }
    }
}