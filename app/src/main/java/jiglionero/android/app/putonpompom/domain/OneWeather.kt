package jiglionero.android.app.putonpompom.domain

import androidx.databinding.ObservableField
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

    enum class DegreesName {
        F, C
    }
}