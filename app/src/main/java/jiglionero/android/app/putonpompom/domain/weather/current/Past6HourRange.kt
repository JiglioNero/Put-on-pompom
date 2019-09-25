package jiglionero.android.app.putonpompom.domain.weather.current

data class Past6HourRange(
    val Maximum: Maximum = Maximum(),
    val Minimum: Minimum = Minimum()
)