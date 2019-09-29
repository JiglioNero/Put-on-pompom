package jiglionero.android.app.putonpompom.data

import android.location.Location
import androidx.lifecycle.MutableLiveData
import jiglionero.android.app.putonpompom.domain.current.WeatherApiResponseCurrent

class WeatherCaller(private val weatherApi: OpenWeatherApi){

    var location: MutableLiveData<Location> = MutableLiveData()

    var weatherApiResponseCurrent: MutableLiveData<WeatherApiResponseCurrent> = MutableLiveData()

    init {
        location.observeForever {
            weatherApi.getCurrentWeather(it.latitude,it.longitude).enqueue(MutableLiveDataCallback(weatherApiResponseCurrent,
                WeatherApiResponseCurrent()
            ))
        }
    }

}