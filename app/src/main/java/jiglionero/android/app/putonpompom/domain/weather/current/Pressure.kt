package jiglionero.android.app.putonpompom.domain.weather.current

data class Pressure(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)