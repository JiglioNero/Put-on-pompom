package jiglionero.android.app.putonpompom.domain.weather.current

data class RealFeelTemperature(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)