package jiglionero.android.app.putonpompom.domain.current

data class Main(
    val humidity: Int = 0,
    val pressure: Double = 0.0,
    val temp: Double = 0.0,
    val temp_max: Double = 0.0,
    val temp_min: Double = 0.0,
    val feels_like: Double = 0.0
)