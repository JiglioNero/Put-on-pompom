package jiglionero.android.app.putonpompom.data

import android.location.Location
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import jiglionero.android.app.putonpompom.domain.location.LocationByApi
import jiglionero.android.app.putonpompom.domain.weather.current.WeatherApiResponseCurrent

class WeatherCaller(private val weatherApi: OpenWeatherApi, lastLocationTask: Task<Location>){

    var location: MutableLiveData<Location> = MutableLiveData()
    var locationByApi: MutableLiveData<LocationByApi> = MutableLiveData()
    var weatherApiResponseCurrent: MutableLiveData<WeatherApiResponseCurrent> = MutableLiveData()

    init {
        lastLocationTask.addOnCompleteListener {
            location.value = it.result
        }

        location.observeForever {
            weatherApi.getLocationByApi("${it.latitude},${it.longitude}").enqueue(MutableLiveDataCallback(locationByApi))
        }

        locationByApi.observeForever {
            weatherApi.getCurrentWeather(it.Key).enqueue(MutableLiveDataCallback(weatherApiResponseCurrent))
        }
    }

}