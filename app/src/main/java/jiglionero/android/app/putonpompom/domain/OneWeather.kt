package jiglionero.android.app.putonpompom.domain

import androidx.lifecycle.MutableLiveData

abstract class OneWeather {
    companion object{
        var degreesNameUse = MutableLiveData(DegreesName.C)
    }

    abstract fun getTemp(): Double

    abstract fun getPressure(): Double
    abstract fun getHumidity(): Int
    abstract fun getWindSpeed(): Double
    abstract fun getWeatherName(): String
    abstract fun getWeatherDescribe(): String

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        var otherWeather = other as OneWeather
        if(getFormatTemp().equals(otherWeather.getFormatTemp())) return false
        if(getHumidity() == otherWeather.getHumidity()) return false
        if(getPressure().equals(otherWeather.getPressure())) return false
        if(getWindSpeed().equals(otherWeather.getWindSpeed())) return false
        if(getWeatherName() == otherWeather.getWeatherName()) return false
        if(getWeatherDescribe() == otherWeather.getWeatherDescribe()) return false

        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }


    enum class DegreesName {
        F, C
    }
}