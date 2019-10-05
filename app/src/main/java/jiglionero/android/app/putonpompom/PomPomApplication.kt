package jiglionero.android.app.putonpompom

import android.app.Activity
import android.app.Application
import android.content.SharedPreferences
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import jiglionero.android.app.putonpompom.di.DaggerWeatherComponent
import jiglionero.android.app.putonpompom.di.WeatherComponent
import jiglionero.android.app.putonpompom.domain.OneWeather
import javax.inject.Inject


class PomPomApplication : Application() {
    companion object {
        lateinit var instance: PomPomApplication
    }
    lateinit var weatherComponent: WeatherComponent
    lateinit var currentActivity: Activity
    @Inject lateinit var locationPeriodicRequest: PeriodicWorkRequest
    @Inject lateinit var sharedPreferences: SharedPreferences



    override fun onCreate() {
        super.onCreate()
        instance = this
        weatherComponent = DaggerWeatherComponent.create()
        weatherComponent.inject(this)

        if (sharedPreferences.contains(resources.getString(R.string.preferences_key_degrees_name))){
            var degName = sharedPreferences.getString(resources.getString(R.string.preferences_key_degrees_name), "")
            degName?.let {
                OneWeather.degreesNameUse.value = OneWeather.DegreesName.valueOf(it)
            }
        }
        OneWeather.degreesNameUse.observeForever {
            sharedPreferences.edit()
                .putString(resources.getString(R.string.preferences_key_degrees_name), it.name)
                .apply()
        }
        WorkManager.getInstance().enqueueUniquePeriodicWork("locationUpdate", ExistingPeriodicWorkPolicy.REPLACE, locationPeriodicRequest)
    }
}