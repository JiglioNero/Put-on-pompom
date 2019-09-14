package jiglionero.android.app.putonpompom

import android.app.Application
import jiglionero.android.app.putonpompom.di.DaggerLocationComponent
import jiglionero.android.app.putonpompom.di.DaggerWeatherComponent
import jiglionero.android.app.putonpompom.di.LocationComponent
import jiglionero.android.app.putonpompom.di.WeatherComponent

class PomPomApplication : Application() {
    companion object {
        lateinit var instance: PomPomApplication
    }
    lateinit var weatherComponent: WeatherComponent
    lateinit var locationComponent: LocationComponent



    override fun onCreate() {
        super.onCreate()
        instance = this
        weatherComponent = DaggerWeatherComponent.create()
        locationComponent = DaggerLocationComponent.create()


    }
}