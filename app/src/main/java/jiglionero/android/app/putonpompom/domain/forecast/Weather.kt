package jiglionero.android.app.putonpompom.domain.forecast

import jiglionero.android.app.putonpompom.domain.room.WeatherEntity

data class Weather(
    val description: String = "",
    val icon: String = "",
    val id: Int = 0,
    val main: String = ""
){
    fun toEntity(oneWeatherId: Int): WeatherEntity{
        return WeatherEntity().apply {
            description = this@Weather.description
            icon = this@Weather.icon
            main= this@Weather.main
            this.oneWeatherId = oneWeatherId
        }
    }
}