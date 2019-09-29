package jiglionero.android.app.putonpompom.domain.forecast

data class Main(
    val grnd_level: Double = 0.0,
    val humidity: Int = 0,
    val pressure: Double = 0.0,
    val sea_level: Double = 0.0,
    val temp: Double = 0.0,
    val temp_kf: Double = 0.0,
    val temp_max: Double = 0.0,
    val temp_min: Double = 0.0
)