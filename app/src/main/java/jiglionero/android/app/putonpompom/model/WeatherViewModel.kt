package jiglionero.android.app.putonpompom.model

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.WeatherCaller
import jiglionero.android.app.putonpompom.domain.weather.WeatherApiResponse
import jiglionero.android.app.putonpompom.domain.weather.current.WeatherApiResponseCurrent

import javax.inject.Inject


class WeatherViewModel : ViewModel() {

    var weatherResponseCurrent: ObservableField<WeatherApiResponseCurrent?>
    var degreesNameUse = ObservableField(DegreesName.C)
    @Inject lateinit var weatherCaller: WeatherCaller

    init {
        PomPomApplication.instance.weatherComponent.inject(this)
        weatherResponseCurrent = ObservableField(weatherCaller.weatherApiResponseCurrent.value)
        weatherCaller.weatherApiResponseCurrent.observeForever {
            weatherResponseCurrent.set(it)
        }
        degreesNameUse.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                weatherResponseCurrent.notifyChange()
            }
        })
    }

    fun switchDegreesName(): ObservableField<DegreesName>{
        if(degreesNameUse.get() == DegreesName.C){
            degreesNameUse.set(DegreesName.F)
        } else{
            degreesNameUse.set(DegreesName.C)
        }
        return degreesNameUse
    }

    fun getFormatTemp(weatherApiResponse: WeatherApiResponse?) : Double{
        if(weatherApiResponse is WeatherApiResponseCurrent) {
            weatherResponseCurrent.get()?.let {
                return when (degreesNameUse.get()) {
                    DegreesName.C -> it.Temperature.Metric.Value
                    DegreesName.F -> it.Temperature.Imperial.Value
                    else -> -273.15
                }
            }
        }
        return -273.15
    }

    enum class DegreesName{
        F,C
    }
}
