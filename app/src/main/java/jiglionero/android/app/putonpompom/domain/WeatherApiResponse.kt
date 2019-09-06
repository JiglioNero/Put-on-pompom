package jiglionero.android.app.putonpompom.domain

import com.google.gson.annotations.SerializedName

class WeatherApiResponse(
    @SerializedName("weather") var weather: ArrayList<Weather>,
    @SerializedName("base") var base: String,
    @SerializedName("main") var mainWeatherParams: WeatherMainParams,
    @SerializedName("wind") var windParams: WeatherWind,
    @SerializedName("clouds") var cloudsParams: WeatherClouds,
    @SerializedName("dt") var dt: Long,
    @SerializedName("sys") var weatherSys: WeatherSys,
    @SerializedName("timezone") var timeZone: Long,
    @SerializedName("id") var id: Long,
    @SerializedName("name") var name: String,
    @SerializedName("cod") var cod: Long
)