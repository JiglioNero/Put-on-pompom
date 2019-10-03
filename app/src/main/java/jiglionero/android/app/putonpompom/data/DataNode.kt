package jiglionero.android.app.putonpompom.data

import android.location.Location
import androidx.lifecycle.MutableLiveData
import jiglionero.android.app.putonpompom.domain.current.WeatherApiResponseCurrent
import jiglionero.android.app.putonpompom.domain.forecast.WeatherApiResponseForecast5D3H

class DataNode(private val weatherApi: OpenWeatherApi, private val database: WeatherDatabase){

    var location: MutableLiveData<Location> = MutableLiveData()

    var weatherApiResponseCurrent: MutableLiveData<WeatherApiResponseCurrent> = MutableLiveData(
        WeatherApiResponseCurrent()
    )
    var weatherApiResponseForecast5D3H: MutableLiveData<WeatherApiResponseForecast5D3H> = MutableLiveData(
        WeatherApiResponseForecast5D3H()
    )

    init {
        location.observeForever {
            weatherApi.getCurrentWeather(it.latitude,it.longitude).enqueue(MutableLiveDataCallback(weatherApiResponseCurrent, WeatherApiResponseCurrent()))
            weatherApi.getForecast5D3HWeather(it.latitude,it.longitude).enqueue(MutableLiveDataCallback(weatherApiResponseForecast5D3H, WeatherApiResponseForecast5D3H()))
        }
    }

}