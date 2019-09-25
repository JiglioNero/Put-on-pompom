package jiglionero.android.app.putonpompom.view.viewmodel

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.WeatherCaller
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import javax.inject.Inject


class WeatherViewModel : ViewModel() {

    var weatherResponse: ObservableField<WeatherApiResponse?>
    var degreesName = ObservableField(DegreesName.C)
    @Inject lateinit var weatherCaller: WeatherCaller

    init {
        PomPomApplication.instance.weatherComponent.inject(this)
        weatherResponse = ObservableField(weatherCaller.weatherApiResponse.value)
        weatherCaller.weatherApiResponse.observeForever {
            weatherResponse.set(it)
        }
        degreesName.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                weatherResponse.notifyChange()
            }
        })
    }

    fun switchDegreesName(): ObservableField<DegreesName>{
        if(degreesName.get() == WeatherViewModel.DegreesName.C){
            degreesName.set(DegreesName.F)
        } else{
            degreesName.set(DegreesName.C)
        }
        return degreesName
    }

    fun getFormatTemp(temp: Float) : Float{
        return when(degreesName.get()){
            DegreesName.C -> temp - 273.15F
            DegreesName.F -> (temp - 273.15F)*9/5 + 32
            else -> - 273.15F
        }
    }

    enum class DegreesName{
        F,C
    }
}
