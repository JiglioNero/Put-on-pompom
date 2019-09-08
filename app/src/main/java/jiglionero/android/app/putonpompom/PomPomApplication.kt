package jiglionero.android.app.putonpompom

import android.app.Application
import jiglionero.android.app.putonpompom.di.WeatherComponent

class PomPomApplication : Application() {
    companion object {
        lateinit var weatherComponent: WeatherComponent
    }

    /*override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger(){
        weatherComponent = initWeatherComponent()
    }

    private fun initWeatherComponent(): WeatherComponent{
        if(weatherComponent == null){
            weatherComponent = DaggerWeatherComponent
                .create()
        }
        return weatherComponent
    }*/
}