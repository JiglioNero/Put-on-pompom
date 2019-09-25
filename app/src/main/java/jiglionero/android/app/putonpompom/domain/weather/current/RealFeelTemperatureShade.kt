package jiglionero.android.app.putonpompom.domain.weather.current

data class RealFeelTemperatureShade(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)