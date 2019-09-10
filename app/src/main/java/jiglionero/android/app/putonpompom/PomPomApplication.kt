package jiglionero.android.app.putonpompom

import android.app.Application
import jiglionero.android.app.putonpompom.di.DaggerWeatherComponent
import jiglionero.android.app.putonpompom.di.WeatherComponent

class PomPomApplication : Application() {
    companion object {
        lateinit var weatherComponent: WeatherComponent
        lateinit var instance: PomPomApplication
    }

    override fun onCreate() {
        super.onCreate()
        weatherComponent = DaggerWeatherComponent.create()
        instance = this
    }
}