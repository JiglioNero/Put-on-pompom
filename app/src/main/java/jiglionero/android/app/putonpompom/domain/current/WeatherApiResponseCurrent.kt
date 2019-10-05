package jiglionero.android.app.putonpompom.domain.current

import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import jiglionero.android.app.putonpompom.domain.forecast.WeatherCurrent

data class WeatherApiResponseCurrent(
    val base: String = "",
    val clouds: Clouds = Clouds(),
    val cod: Int = 0,
    val coord: Coord = Coord(),
    val dt: Long = 0,
    val id: Int = 0,
    val main: Main = Main(),
    val name: String = "",
    val sys: Sys = Sys(),
    val timezone: Int = 0,
    val weather: ArrayList<Weather> = arrayListOf(Weather()),
    val wind: Wind = Wind()
): OneWeather(), WeatherApiResponse {
    override fun getWeatherIconId(): String {
        return weather[0].icon
    }

    fun toWeatherCurrent(): WeatherCurrent{
        return WeatherCurrent(
            clouds = clouds,
            dt = dt,
            main = jiglionero.android.app.putonpompom.domain.forecast.Main(
                humidity = main.humidity,
                pressure = main.pressure,
                temp = main.temp,
                temp_max = main.temp_max,
                temp_min = main.temp_min
            ),
            weatherP = weather[0],
            wind = wind
        )
    }

    override fun getWeathers(): List<Weather> {
        return weather
    }

    override fun setWeather(weatherList: List<Weather>) {
        weather.clear()
        weather.addAll(weatherList)
    }

    override fun getDate(): Long {
        return dt * 1000
    }

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