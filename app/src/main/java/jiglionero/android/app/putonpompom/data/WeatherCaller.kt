package jiglionero.android.app.putonpompom.data

import android.location.Location
import androidx.lifecycle.MutableLiveData
import jiglionero.android.app.putonpompom.domain.location.LocationByApi
import jiglionero.android.app.putonpompom.domain.weather.current.WeatherApiResponseCurrent
import jiglionero.android.app.putonpompom.domain.weather.forecast.WeatherApiResponseForecast12H

class WeatherCaller(private val weatherApi: OpenWeatherApi){

    var location: MutableLiveData<Location> = MutableLiveData()
    var locationByApi: MutableLiveData<LocationByApi> = MutableLiveData()

    var weatherApiResponseCurrent: MutableLiveData<WeatherApiResponseCurrent> = MutableLiveData()
    var weatherApiResponseForecast12H: MutableLiveData<WeatherApiResponseForecast12H> = MutableLiveData()

    init {
        location.observeForever {
            weatherApi.getLocationByApi("${it.latitude},${it.longitude}").enqueue(MutableLiveDataCallback(locationByApi, LocationByApi()))
        }

        locationByApi.observeForever {
            weatherApi.getCurrentWeather(it.Key).enqueue(MutableLiveDataCallback(weatherApiResponseCurrent, WeatherApiResponseCurrent()))
            //weatherApi.get12HourForecastWeather(it.Key).enqueue(MutableLiveDataCallback(weatherApiResponseForecast12H, WeatherApiResponseForecast12H()))
        }
    }

}