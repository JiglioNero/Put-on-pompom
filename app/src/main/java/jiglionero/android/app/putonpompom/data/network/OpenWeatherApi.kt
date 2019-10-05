package jiglionero.android.app.putonpompom.data.network

import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.domain.current.WeatherApiResponseCurrent
import jiglionero.android.app.putonpompom.domain.forecast.WeatherApiResponseForecast5D3H
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface OpenWeatherApi{
    @GET("data/2.5/weather")
    fun getCurrentWeather(@Query("lat") latitude:Double,
                          @Query("lon") longitude:Double,
                          @Query("APPID") appId: String = PomPomApplication.instance.resources.getString(R.string.app_id))
            : Call<WeatherApiResponseCurrent>

    @GET("data/2.5/forecast")
    fun getForecast5D3HWeather(@Query("lat") latitude:Double,
                          @Query("lon") longitude:Double,
                          @Query("APPID") appId: String = PomPomApplication.instance.resources.getString(R.string.app_id))
            : Call<WeatherApiResponseForecast5D3H>

}