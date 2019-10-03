package jiglionero.android.app.putonpompom.data

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import jiglionero.android.app.putonpompom.domain.current.WeatherApiResponseCurrent
import jiglionero.android.app.putonpompom.domain.forecast.WeatherApiResponseForecast5D3H
import jiglionero.android.app.putonpompom.domain.forecast.WeatherCurrent
import java.util.*

class DataNode(private val weatherApi: OpenWeatherApi, private val database: WeatherDatabase){

    var location: MutableLiveData<Location> = MutableLiveData()

    private var weatherApiResponseCurrent: MutableLiveData<WeatherApiResponseCurrent> = MutableLiveData()
    private var weatherApiResponseForecast5D3H: MutableLiveData<WeatherApiResponseForecast5D3H> = MutableLiveData()

    private var currentWeatherFromDB: LiveData<List<WeatherCurrent>> = database.getAllCurrentWeathersSortedByDate()

    var current: MutableLiveData<WeatherCurrent> = MutableLiveData()
    var forecastList: MutableLiveData<ArrayList<WeatherCurrent>> = MutableLiveData()

    init {
        initObserve()
    }

    fun buildResponseFromDB(){
        currentWeatherFromDB.value?.let {
            val list = database.buildToActual(it)
            if(list.size>0) {
                current.value = list[0]
                list.removeAt(0)
                forecastList.value = list
            }
        }
    }

    fun initObserve(){
        location.observeForever {
            weatherApi.getCurrentWeather(it.latitude,it.longitude).enqueue(MutableLiveDataCallback(weatherApiResponseCurrent, WeatherApiResponseCurrent()))
            weatherApi.getForecast5D3HWeather(it.latitude,it.longitude).enqueue(MutableLiveDataCallback(weatherApiResponseForecast5D3H, WeatherApiResponseForecast5D3H()))
        }

        weatherApiResponseCurrent.observeForever {
            weatherApiResponseForecast5D3H.value?.let { forecastResponse ->
                val list = arrayListOf(it.toWeatherCurrent())
                list.addAll(forecastResponse.list)
                Thread {
                    database.saveAllCurrentWeathers(list)
                }.start()
            }
        }

        weatherApiResponseForecast5D3H.observeForever {
            weatherApiResponseCurrent.value?.let { currentResponse ->
                val list = arrayListOf(currentResponse.toWeatherCurrent())
                list.addAll(it.list)
                Thread {
                    database.saveAllCurrentWeathers(list)
                }.start()
            }
        }

        currentWeatherFromDB.observeForever{
           buildResponseFromDB()
        }
    }


}