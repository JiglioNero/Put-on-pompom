package jiglionero.android.app.putonpompom.di

import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.data.network.OpenWeatherApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class WeatherAPIModule {

    @Provides
    fun baseUrl() = PomPomApplication.instance.resources.getString(R.string.base_weather_api_url)

    @Singleton
    @Provides
    fun getWeatherApi(retrofit: Retrofit): OpenWeatherApi {
        return retrofit.create(OpenWeatherApi::class.java)
    }

}