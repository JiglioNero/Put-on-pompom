package jiglionero.android.app.putonpompom.domain.forecast


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.domain.current.Clouds
import jiglionero.android.app.putonpompom.domain.current.Weather
import jiglionero.android.app.putonpompom.domain.current.Wind

@Entity
data class WeatherCurrent(
    @Embedded
    var clouds: Clouds = Clouds(),
    var dt: Long = 0,
    var dt_txt: String = "blank",
    @Embedded
    var main: Main = Main(),
    @Embedded
    var rain: Rain = Rain(),
    @Embedded
    var sys: Sys = Sys(),
    @Ignore
    var weather: ArrayList<Weather> = arrayListOf(Weather()),
    @Embedded
    var wind: Wind = Wind(),
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @Embedded
    var weatherP: Weather = Weather()
): OneWeather() {

    override fun getWeatherIconId(): String {
        return weatherP.icon
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

    override fun getWeatherName(): String {
        return weatherP.main
    }

    override fun getWeatherDescribe(): String {
        return weatherP.description
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