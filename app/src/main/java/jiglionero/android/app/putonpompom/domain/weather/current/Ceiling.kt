package jiglionero.android.app.putonpompom.domain.weather.current

data class Ceiling(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)