package jiglionero.android.app.putonpompom.model

import androidx.databinding.*
import androidx.lifecycle.ViewModel
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.WeatherCaller
import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import javax.inject.Inject

abstract class WeatherViewModel: ViewModel() {
    @Inject
    lateinit var weatherCaller: WeatherCaller
    @Inject
    lateinit var listChangeRegistry: ListChangeRegistry
    var weatherApiResponse: ObservableField<WeatherApiResponse> = ObservableField()
    var oneWeatherList: ObservableList<OneWeather> = ObservableArrayList()

    init {
        PomPomApplication.instance.weatherComponent.inject(this)
        this.initObservable()
        this.initObserveResponse()
        weatherApiResponse.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                oneWeatherList.clear()
                weatherApiResponse.get()?.let {
                    oneWeatherList.addAll(it.getOneWeatherList())
                }
            }

        })
        OneWeather.degreesNameUse.observeForever{
            weatherApiResponse.notifyChange()
        }
    }

    abstract fun initObservable()

    abstract fun initObserveResponse()

}