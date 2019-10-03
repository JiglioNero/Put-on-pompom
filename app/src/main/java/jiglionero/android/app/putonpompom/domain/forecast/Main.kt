package jiglionero.android.app.putonpompom.domain.forecast

import jiglionero.android.app.putonpompom.domain.room.MainEntity

data class Main(
    val grnd_level: Double = 0.0,
    val humidity: Int = 0,
    val pressure: Double = 0.0,
    val sea_level: Double = 0.0,
    val temp: Double = 0.0,
    val temp_kf: Double = 0.0,
    val temp_max: Double = 0.0,
    val temp_min: Double = 0.0
){
    fun toEntity(): MainEntity{
        return MainEntity().apply {
            humidity = this@Main.humidity
            pressure = this@Main.pressure
            temp = this@Main.temp
            temp_max = this@Main.temp_max
            temp_min = this@Main.temp_min
        }
    }
}