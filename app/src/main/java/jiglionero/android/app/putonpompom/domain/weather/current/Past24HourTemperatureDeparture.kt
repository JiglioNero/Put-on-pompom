package jiglionero.android.app.putonpompom.domain.weather.current

data class Past24HourTemperatureDeparture(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)