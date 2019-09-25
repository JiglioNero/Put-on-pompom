package jiglionero.android.app.putonpompom.domain.weather.current

data class WetBulbTemperature(
    val Imperial: Imperial = Imperial(),
    val Metric: Metric = Metric()
)