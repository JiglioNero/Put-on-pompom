package jiglionero.android.app.putonpompom.domain

interface WeatherApiResponse {
    fun getOneWeatherList(): List<OneWeather>
}