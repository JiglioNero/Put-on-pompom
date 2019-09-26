package jiglionero.android.app.putonpompom

import android.app.Activity
import android.app.Application
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import jiglionero.android.app.putonpompom.di.DaggerWeatherComponent
import jiglionero.android.app.putonpompom.di.WeatherComponent
import javax.inject.Inject


class PomPomApplication : Application() {
    companion object {
        lateinit var instance: PomPomApplication
    }
    lateinit var weatherComponent: WeatherComponent
    lateinit var currentActivity: Activity
    @Inject lateinit var locationPeriodicRequest: PeriodicWorkRequest



    override fun onCreate() {
        super.onCreate()
        instance = this
        weatherComponent = DaggerWeatherComponent.create()
        weatherComponent.inject(this)

        WorkManager.getInstance().enqueue(locationPeriodicRequest)
    }
}