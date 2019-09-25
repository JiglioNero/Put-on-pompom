package jiglionero.android.app.putonpompom.data

import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.domain.location.LocationByApi
import jiglionero.android.app.putonpompom.domain.weather.current.WeatherApiResponseCurrent
import jiglionero.android.app.putonpompom.domain.weather.forecast.WeatherApiResponseForecast12H
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenWeatherApi{
    @GET("forecasts/v1/hourly/12hour/{localKey}")
    fun get12HourForecastWeather(@Path("localKey") localKey: String,
                                 @Query("apikey") appId: String = PomPomApplication.instance.resources.getString(R.string.app_id),
                                 @Query("language") language: String = PomPomApplication.instance.resources.configuration.locale.country,
                                 @Query("details") details: Boolean = true,
                                 @Query("metric") metric: Boolean = true): Call<WeatherApiResponseForecast12H>

    @GET("currentconditions/v1/{localKey}")
    fun getCurrentWeather(@Path("localKey") localKey: String,
                                 @Query("apikey") appId: String = PomPomApplication.instance.resources.getString(R.string.app_id),
                                 @Query("language") language: String = PomPomApplication.instance.resources.configuration.locale.country,
                                 @Query("details") details: Boolean = true): Call<WeatherApiResponseCurrent>

    @GET("locations/v1/cities/geoposition/search")
    fun getLocationByApi(@Query("q") latAndlon: String,
                         @Query("apikey") appId: String = PomPomApplication.instance.resources.getString(R.string.app_id)): Call<LocationByApi>
}