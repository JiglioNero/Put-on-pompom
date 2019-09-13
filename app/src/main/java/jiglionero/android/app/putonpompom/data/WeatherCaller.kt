package jiglionero.android.app.putonpompom.data

import android.location.Location
import android.location.LocationManager

class WeatherCaller(weatherApi: OpenWeatherApi, locationRequest: LocationRequest){
    val weatherApi: OpenWeatherApi = weatherApi
    val locationManager: LocationManager = locationManager
    var location: Location

    init {
        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
    }

    fun getWeatherCall(){
        locationManager.
        weatherApi.getCurrentWeather()
    }
}