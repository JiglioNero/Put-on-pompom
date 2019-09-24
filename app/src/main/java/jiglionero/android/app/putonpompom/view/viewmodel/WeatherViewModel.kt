package jiglionero.android.app.putonpompom.view.viewmodel


import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.WeatherCaller
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import javax.inject.Inject


class WeatherViewModel : ViewModel() {

    var weatherResponse: ObservableField<WeatherApiResponse?>
    var degreesName = DegreesName.C
    set(value) {
        field = value
        weatherResponse.notifyChange()
    }
    @Inject lateinit var weatherCaller: WeatherCaller

    init {
        PomPomApplication.instance.weatherComponent.inject(this)
        weatherResponse = ObservableField(weatherCaller.weatherApiResponse.value)
        weatherCaller.weatherApiResponse.observeForever {
            weatherResponse.set(it)
        }
    }

    fun getFormatTemp(temp: Float) : Float{
        return when(degreesName){
            DegreesName.C -> temp - 273.15F
            DegreesName.F -> (temp - 273.15F)*9/5 + 32
        }
    }

    enum class DegreesName{
        F,C
    }
}
