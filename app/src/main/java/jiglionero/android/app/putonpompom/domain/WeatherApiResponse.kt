package jiglionero.android.app.putonpompom.domain

import com.google.gson.annotations.SerializedName

class WeatherApiResponse(
    //@SerializedName("coord") var  coord: WeatherCoord = WeatherCoord(),
    @SerializedName("weather") var weather: List<Weather> = listOf(Weather()),
    @SerializedName("base") var base: String = "",
    @SerializedName("main") var mainWeatherParams: WeatherMainParams = WeatherMainParams(),
    @SerializedName("wind") var windParams: WeatherWind = WeatherWind(),
    @SerializedName("clouds") var cloudsParams: WeatherClouds = WeatherClouds(),
    @SerializedName("dt") var dt: Long = 0,
    @SerializedName("sys") var weatherSys: WeatherSys = WeatherSys(),
    @SerializedName("timezone") var timeZone: Long = 0,
    @SerializedName("id") var id: Long = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("cod") var cod: Long = 0
)