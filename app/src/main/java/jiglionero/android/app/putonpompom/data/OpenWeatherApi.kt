package jiglionero.android.app.putonpompom.data

import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi{
    @GET("/weather")
    fun getCurrentWeather(@Query("q") cityName:String): Call<WeatherApiResponse>
}