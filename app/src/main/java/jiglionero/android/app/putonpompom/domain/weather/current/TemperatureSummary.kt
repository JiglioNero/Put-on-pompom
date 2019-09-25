package jiglionero.android.app.putonpompom.domain.weather.current

data class TemperatureSummary(
    val Past12HourRange: Past12HourRange = Past12HourRange(),
    val Past24HourRange: Past24HourRange = Past24HourRange(),
    val Past6HourRange: Past6HourRange = Past6HourRange()
)