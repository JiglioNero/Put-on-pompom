package jiglionero.android.app.putonpompom.domain.weather.current

data class Past24HourRange(
    val Maximum: Maximum = Maximum(),
    val Minimum: Minimum = Minimum()
)