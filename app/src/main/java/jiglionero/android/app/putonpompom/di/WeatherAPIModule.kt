package jiglionero.android.app.putonpompom.di

import android.location.Location
import com.google.android.gms.tasks.Task
import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.data.OpenWeatherApi
import jiglionero.android.app.putonpompom.data.WeatherCaller
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class WeatherAPIModule {

    @Provides
    fun baseUrl() = PomPomApplication.instance.resources.getString(R.string.base_weather_url)

    @Singleton
    @Provides
    fun getWeatherApi(retrofit: Retrofit): OpenWeatherApi {
        return retrofit.create(OpenWeatherApi::class.java)
    }

    @Singleton
    @Provides
    fun getWeatherCaller(openWeatherApi: OpenWeatherApi, lastLocationTask: Task<Location>): WeatherCaller{
        return WeatherCaller(openWeatherApi, lastLocationTask)
    }
}