package jiglionero.android.app.putonpompom.domain.weather.current

data class WindChillTemperature(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)