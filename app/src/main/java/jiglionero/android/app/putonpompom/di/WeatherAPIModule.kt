package jiglionero.android.app.putonpompom.di

import androidx.work.*
import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.data.OpenWeatherApi
import jiglionero.android.app.putonpompom.data.WeatherWorker
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class WeatherAPIModule {

    @Provides
    fun baseUrl() = PomPomApplication.instance.resources.getString(R.string.base_weather_url)

    @Provides
    @Named("cityName")
    fun cityName() = "Yaroslavl"

    @Provides
    @Named("appId")
    fun appId() = PomPomApplication.instance.resources.getString(R.string.app_id)

    @Provides
    fun getWeatherWorkerInputData(@Named("cityName") cityName: String, @Named("appId") appId: String): Data{
        return Data.Builder()
            .putString("cityName", cityName)
            .putString("appId", appId)
            .build()
    }

    @Provides
    fun getWeatherWokerConstraints(): Constraints{
        return Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresDeviceIdle(false)
            .build()
    }

    @Provides
    fun getWeatherWorkRequest(inputData: Data): OneTimeWorkRequest{
        return OneTimeWorkRequest.Builder(WeatherWorker::class.java)
            .setInputData(inputData)
            .build()
    }

    @Provides
    fun getWeatherWorkRequestRepeater(oneTimeWorkRequest: OneTimeWorkRequest, constraints: Constraints): PeriodicWorkRequest{
        PeriodicWorkRequest.Builder()
    }

    @Provides
    fun getCallWeatherApiResponse(openWeatherApi: OpenWeatherApi, @Named("cityName") cityName: String, @Named("appId") appId: String): Call<WeatherApiResponse>{
        return openWeatherApi.getCurrentWeather(cityName, appId)
    }

    @Singleton
    @Provides
    fun getWeatherApi(retrofit: Retrofit): OpenWeatherApi {
        return retrofit.create(OpenWeatherApi::class.java)
    }
}