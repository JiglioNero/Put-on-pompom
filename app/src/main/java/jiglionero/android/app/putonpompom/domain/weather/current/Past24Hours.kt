package jiglionero.android.app.putonpompom.domain.weather.current

data class Past24Hours(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)