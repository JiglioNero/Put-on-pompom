package jiglionero.android.app.putonpompom.model

import androidx.databinding.Observable
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.DataNode
import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import javax.inject.Inject


class WeatherCurrentViewModel : ViewModel() {
    @Inject
    lateinit var dataNode: DataNode
    var weatherApiResponse: ObservableField<WeatherApiResponse> = ObservableField()
    var oneWeatherList: ObservableList<OneWeather> = ObservableArrayList()

    init {
        PomPomApplication.instance.weatherComponent.inject(this)
        this.initObservable()
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

    fun initObserveResponse(lifeCycleOwner: LifecycleOwner) {
        dataNode.weatherApiResponseCurrent.observe(lifeCycleOwner, Observer{
            weatherApiResponse.set(it)
        })
    }

    fun initObservable() {
        val weatherApiResponseCurrent = dataNode.weatherApiResponseCurrent.value
        weatherApiResponse.set(weatherApiResponseCurrent)
        oneWeatherList.add(weatherApiResponseCurrent)
    }
}
