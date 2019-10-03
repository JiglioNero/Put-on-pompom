package jiglionero.android.app.putonpompom.domain.room

import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse

class WeatherApiResponseRoom(
    val list: List<FullWeatherFromRoom>
): WeatherApiResponse {
    override fun getOneWeatherList(): List<OneWeather> {
        return list
    }
}