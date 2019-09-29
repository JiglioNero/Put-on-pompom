package jiglionero.android.app.putonpompom.domain.forecast

import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse

data class WeatherApiResponseForecast5D3H(
    val city: City = City(),
    val cnt: Int = 0,
    val cod: String = "",
    val list: List<WeatherCurrent> = listOf(),
    val message: Double = 0.0
): WeatherApiResponse {
    override fun getOneWeatherList(): List<OneWeather> {
        return list
    }
}