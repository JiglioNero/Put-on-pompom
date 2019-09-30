package jiglionero.android.app.putonpompom.domain.forecast

import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.domain.current.Clouds
import jiglionero.android.app.putonpompom.domain.current.Weather
import jiglionero.android.app.putonpompom.domain.current.Wind

data class WeatherCurrent(
    val clouds: Clouds = Clouds(),
    val dt: Long = 0,
    val dt_txt: String = "",
    val main: Main = Main(),
    val rain: Rain = Rain(),
    val sys: Sys = Sys(),
    val weather: List<Weather> = listOf(),
    val wind: Wind = Wind()
): OneWeather() {
    override fun getDate(): Long {
        return dt
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