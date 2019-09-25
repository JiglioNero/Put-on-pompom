package jiglionero.android.app.putonpompom.domain.weather.current

data class ApparentTemperature(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)