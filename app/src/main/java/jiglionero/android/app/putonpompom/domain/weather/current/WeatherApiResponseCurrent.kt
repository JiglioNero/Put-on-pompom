package jiglionero.android.app.putonpompom.domain.weather.current

import androidx.annotation.NonNull

data class WeatherApiResponseCurrent(
    @NonNull val ApparentTemperature: ApparentTemperature = ApparentTemperature(),
    @NonNull val Ceiling: Ceiling = Ceiling(),
    @NonNull val CloudCover: Int = 0,
    @NonNull val DewPoint: DewPoint = DewPoint(),
    @NonNull val EpochTime: Int = 0,
    @NonNull val HasPrecipitation: Boolean = false,
    @NonNull val IsDayTime: Boolean = false,
    @NonNull val Link: String = "",
    @NonNull val LocalObservationDateTime: String = "",
    @NonNull val MobileLink: String = "",
    @NonNull val ObstructionsToVisibility: String = "",
    @NonNull val Past24HourTemperatureDeparture: Past24HourTemperatureDeparture = Past24HourTemperatureDeparture(),
    @NonNull val Precip1hr: Precip1hr = Precip1hr(),
    @NonNull val PrecipitationSummary: PrecipitationSummary = PrecipitationSummary(),
    @NonNull val PrecipitationType: Any = Any(),
    @NonNull val Pressure: Pressure = Pressure(),
    @NonNull val PressureTendency: PressureTendency = PressureTendency(),
    @NonNull val RealFeelTemperature: RealFeelTemperature = RealFeelTemperature(),
    @NonNull val RealFeelTemperatureShade: RealFeelTemperatureShade = RealFeelTemperatureShade(),
    @NonNull val RelativeHumidity: Int = 0,
    @NonNull val Temperature: Temperature = Temperature(),
    @NonNull val TemperatureSummary: TemperatureSummary = TemperatureSummary(),
    @NonNull val UVIndex: Int = 0,
    @NonNull val UVIndexText: String = "",
    @NonNull val Visibility: Visibility = Visibility(),
    @NonNull val WeatherIcon: Int = 0,
    @NonNull val WeatherText: String = "",
    @NonNull val WetBulbTemperature: WetBulbTemperature = WetBulbTemperature(),
    @NonNull val Wind: Wind = Wind(),
    @NonNull val WindChillTemperature: WindChillTemperature = WindChillTemperature(),
    @NonNull val WindGust: WindGust = WindGust()
)