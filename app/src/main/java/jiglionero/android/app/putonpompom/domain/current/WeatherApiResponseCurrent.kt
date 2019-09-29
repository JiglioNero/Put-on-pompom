package jiglionero.android.app.putonpompom.domain.current

import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse

data class WeatherApiResponseCurrent(
    val base: String = "",
    val clouds: Clouds = Clouds(),
    val cod: Int = 0,
    val coord: Coord = Coord(),
    val dt: Int = 0,
    val id: Int = 0,
    val main: Main = Main(),
    val name: String = "",
    val sys: Sys = Sys(),
    val timezone: Int = 0,
    val weather: List<Weather> = listOf(Weather()),
    val wind: Wind = Wind()
): OneWeather(), WeatherApiResponse {

    override fun getOneWeatherList(): List<OneWeather> {
        return listOf(this)
    }

    override fun getWeatherName(): String {
        return weather[0].main
    }

    override fun getWeatherDescribe(): String {
        return weather[0].description
    }

    override fun getPressure(): Double {
        return main.pressure
    }

    override fun getHumidity(): Int {
        return main.humidity
    }

    override fun getWindSpeed(): Double {
        return wind.speed
    }

    override fun getTemp(): Double {
        return main.temp
    }
}