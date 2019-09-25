package jiglionero.android.app.putonpompom.domain.weather.current

data class Past6Hours(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)