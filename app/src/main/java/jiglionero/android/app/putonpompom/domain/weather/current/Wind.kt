package jiglionero.android.app.putonpompom.domain.weather.current

data class Wind(
    val Direction: Direction = Direction(),
    val Speed: Speed = Speed()
)