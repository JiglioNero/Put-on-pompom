package jiglionero.android.app.putonpompom.domain.weather.forecast

data class Wind(
    val Direction: Direction = Direction(),
    val Speed: Speed = Speed()
)