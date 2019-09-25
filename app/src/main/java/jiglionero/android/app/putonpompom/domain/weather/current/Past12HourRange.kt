package jiglionero.android.app.putonpompom.domain.weather.current

data class Past12HourRange(
    val Maximum: Maximum = Maximum(),
    val Minimum: Minimum = Minimum()
)