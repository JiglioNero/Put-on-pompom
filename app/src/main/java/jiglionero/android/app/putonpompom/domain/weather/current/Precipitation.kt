package jiglionero.android.app.putonpompom.domain.weather.current

data class Precipitation(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)