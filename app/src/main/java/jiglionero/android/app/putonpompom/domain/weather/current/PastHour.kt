package jiglionero.android.app.putonpompom.domain.weather.current

data class PastHour(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)