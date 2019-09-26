package jiglionero.android.app.putonpompom.domain.weather.forecast

import jiglionero.android.app.putonpompom.domain.weather.WeatherApiResponse

data class WeatherApiResponseForecast12H(
    val Ceiling: Ceiling = Ceiling(),
    val CloudCover: Int = 0,
    val DateTime: String = "",
    val DewPoint: DewPoint = DewPoint(),
    val EpochDateTime: Int = 0,
    val HasPrecipitation: Boolean = false,
    val Ice: Ice = Ice(),
    val IceProbability: Int = 0,
    val IconPhrase: String = "",
    val IsDaylight: Boolean = false,
    val Link: String = "",
    val MobileLink: String = "",
    val PrecipitationProbability: Int = 0,
    val Rain: Rain = Rain(),
    val RainProbability: Int = 0,
    val RealFeelTemperature: RealFeelTemperature = RealFeelTemperature(),
    val RelativeHumidity: Int = 0,
    val Snow: Snow = Snow(),
    val SnowProbability: Int = 0,
    val Temperature: Temperature = Temperature(),
    val TotalLiquid: TotalLiquid = TotalLiquid(),
    val UVIndex: Int = 0,
    val UVIndexText: String = "",
    val Visibility: Visibility = Visibility(),
    val WeatherIcon: Int = 0,
    val WetBulbTemperature: WetBulbTemperature = WetBulbTemperature(),
    val Wind: Wind = Wind(),
    val WindGust: WindGust = WindGust()
): WeatherApiResponse