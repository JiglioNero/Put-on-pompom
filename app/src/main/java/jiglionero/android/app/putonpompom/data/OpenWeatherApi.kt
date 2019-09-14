package jiglionero.android.app.putonpompom.data

import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi{
    @GET("weather")
    fun getCurrentWeather(@Query("lat") latitude:Double, @Query("lon") longitude:Double, @Query("APPID") appId: String): Call<WeatherApiResponse>
}