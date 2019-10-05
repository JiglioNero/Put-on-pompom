package jiglionero.android.app.putonpompom.domain

import androidx.lifecycle.MutableLiveData
import jiglionero.android.app.putonpompom.domain.current.Weather
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.floor


abstract class OneWeather {
    companion object{
        var degreesNameUse = MutableLiveData(DegreesName.C)
    }

    protected abstract fun getTemp(): Double
    abstract fun getPressure(): Double
    abstract fun getHumidity(): Int
    abstract fun getWindSpeed(): Double
    abstract fun getWeatherName(): String
    abstract fun getWeatherDescribe(): String
    abstract fun getWeatherIconId(): String
    abstract fun getDate():Long
    abstract fun getWeathers():List<Weather>

    fun getFormatTime(): String{
        return SimpleDateFormat("HH:mm").format(Date(getDate()))
    }

    fun getFormatDate(): String{
        return SimpleDateFormat("dd:MMMM").format(Date(getDate()))
    }

    fun getFormatRoundedTemp(): String {
        val temp = getFormatTemp()
        return if(floor(temp) == temp){
            val t = temp.toInt()
            String.format("$t")
        } else {
            String.format("%.1f", getFormatTemp())
        }
    }

    fun getFormatTemp(): Double {
        return when (degreesNameUse.value) {
            DegreesName.C -> getTemp() - 273.15
            DegreesName.F -> (getTemp() - 273.15) * 9 / 5 + 32
            else -> -273.15
        }
    }

    fun getDegreesNameUse(): MutableLiveData<DegreesName> {
        return degreesNameUse
    }

    fun switchDegreesName(): MutableLiveData<DegreesName> {
        if (degreesNameUse.value == DegreesName.C) {
            degreesNameUse.value = DegreesName.F
        } else {
            degreesNameUse.value = DegreesName.C
        }
        return degreesNameUse
    }

    abstract fun setWeather(weatherList: List<Weather>)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        var otherWeather = other as OneWeather
        if(!getFormatTemp().equals(otherWeather.getFormatTemp())) return false
        if(getHumidity() != otherWeather.getHumidity()) return false
        if(!getPressure().equals(otherWeather.getPressure())) return false
        if(!getWindSpeed().equals(otherWeather.getWindSpeed())) return false
        if(getWeatherName() != otherWeather.getWeatherName()) return false
        if(getWeatherDescribe() != otherWeather.getWeatherDescribe()) return false
        if(getDate() != otherWeather.getDate()) return false

        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }


    enum class DegreesName {
        F, C
    }
}