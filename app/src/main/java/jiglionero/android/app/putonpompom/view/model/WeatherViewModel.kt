package jiglionero.android.app.putonpompom.view.model


import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.WeatherCaller
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import javax.inject.Inject


class WeatherViewModel : ViewModel() {

    var weatherResponse: ObservableField<WeatherApiResponse?>
    @Inject lateinit var weatherCaller: WeatherCaller

        init {
            PomPomApplication.instance.weatherComponent.inject(this)
            weatherResponse = ObservableField(weatherCaller.weatherApiResponse.value)
            weatherCaller.weatherApiResponse.observeForever {
                weatherResponse.set(it)
            }
        }

}
