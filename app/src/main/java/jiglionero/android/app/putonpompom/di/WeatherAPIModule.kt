package jiglionero.android.app.putonpompom.di

import android.content.res.Resources
import androidx.databinding.ObservableField
import dagger.Module
import dagger.Provides
import dagger.multibindings.StringKey
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.data.OpenWeatherApi
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class WeatherAPIModule {

    @Provides
    fun baseUrl(): String = PomPomApplication.instance.resources.getString(R.string.base_weather_url)

    @Provides
    @Named
    fun cityName() = "Yaroslavl"

    @Provides
    fun getObservableFieldWeatherApiResponse(weatherApiResponse: WeatherApiResponse?): ObservableField<WeatherApiResponse?>{
        return ObservableField(weatherApiResponse)
    }

    @Provides
    fun getWeatherApiResponse(openWeatherApi: OpenWeatherApi, @Named cityName: String): WeatherApiResponse?{
        var response = openWeatherApi.getCurrentWeather(cityName).execute()
        return response.body()
    }

    @Singleton
    @Provides
    fun getWeatherApi(retrofit: Retrofit): OpenWeatherApi {
        return retrofit.create(OpenWeatherApi::class.java)
    }
}