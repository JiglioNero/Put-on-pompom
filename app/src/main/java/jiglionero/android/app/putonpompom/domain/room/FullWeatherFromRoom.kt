package jiglionero.android.app.putonpompom.domain.room

import androidx.room.Relation
import jiglionero.android.app.putonpompom.domain.OneWeather

class FullWeatherFromRoom: OneWeather() {
    @Relation(parentColumn = "cloudsId", entityColumn = "id")
    var clouds: CloudsEntity = CloudsEntity()
    var dt: Long = 0
    @Relation(parentColumn = "mainId", entityColumn = "id")
    var main: MainEntity = MainEntity()
    @Relation(parentColumn = "sysId", entityColumn = "id")
    var sys: SysEntity = SysEntity()
    @Relation(parentColumn = "id", entityColumn = "oneWeatherId")
    var weather: List<WeatherEntity> = listOf()
    @Relation(parentColumn = "windId", entityColumn = "id")
    var wind: WindEntity = WindEntity()
    
    override fun getDate(): Long {
        return dt
    }

    override fun getWeatherName(): String {
        return weather[0].main
    }

    override fun getWeatherDescribe(): String {
        return weather[0].description
    }

    override fun getPressure(): Double {
        return main.pressure
    }

    override fun getHumidity(): Int {
        return main.humidity
    }

    override fun getWindSpeed(): Double {
        return wind.speed
    }

    override fun getTemp(): Double {
        return main.temp
    }

}