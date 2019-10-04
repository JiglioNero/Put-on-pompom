package jiglionero.android.app.putonpompom.data

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.network.NetworkUtil
import jiglionero.android.app.putonpompom.data.network.OpenWeatherApi
import jiglionero.android.app.putonpompom.domain.current.WeatherApiResponseCurrent
import jiglionero.android.app.putonpompom.domain.forecast.WeatherApiResponseForecast5D3H
import jiglionero.android.app.putonpompom.domain.forecast.WeatherCurrent
import java.util.*

class DataNode(private val weatherApi: OpenWeatherApi,
               private val database: WeatherDatabase,
               private var locationRequest: LocationRequest,
               private var locationClient: FusedLocationProviderClient){

    private var locationCallback: LocationCallback = object: LocationCallback(){
        override fun onLocationResult(locationResult: LocationResult?) {
            locationResult ?: return
            for (location in locationResult.locations){
                this@DataNode.location.value = location
            }
        }
    }
    private var location: MutableLiveData<Location> = MutableLiveData()
    var isUpdateObservable = ObservableBoolean(false)

    private var weatherApiResponseCurrent: MutableLiveData<WeatherApiResponseCurrent> = MutableLiveData()
    private var weatherApiResponseForecast5D3H: MutableLiveData<WeatherApiResponseForecast5D3H> = MutableLiveData()

    private var currentWeatherFromDB: LiveData<List<WeatherCurrent>> = database.getAllCurrentWeathersSortedByDate()

    var current: MutableLiveData<WeatherCurrent> = MutableLiveData()
    var forecastList: MutableLiveData<ArrayList<WeatherCurrent>> = MutableLiveData()

    init {
        initObserve()
    }

    private fun buildResponseFromDB(){
        currentWeatherFromDB.value?.let {
            val list = database.buildToActual(it)
            if(list.size>0) {
                current.value = list[0]
                list.removeAt(0)
                forecastList.value = list
            }
        }
    }

    fun tryToStartUpdate(){
        if(NetworkUtil.getConnectivityStatusString(PomPomApplication.instance) != NetworkUtil.NETWORK_STATUS_NOT_CONNECTED) {
            if (isGetPermission()) {
                isUpdateObservable.set(true)
            } else {
                tryToGetPermissions()
                if (isGetPermission()) {
                    isUpdateObservable.set(true)
                }
                else{
                    isUpdateObservable.set(false)
                    isUpdateObservable.notifyChange()
                }
            }
        }
        else{
            isUpdateObservable.set(false)
            isUpdateObservable.notifyChange()
        }
    }

    private fun isGetPermission(): Boolean {
        if (ActivityCompat
                .checkSelfPermission(
                    PomPomApplication.instance.currentActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) ==
            PackageManager.PERMISSION_GRANTED &&
            ActivityCompat
                .checkSelfPermission(
                    PomPomApplication.instance.currentActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun tryToGetPermissions() {

        val fineLocationPermission = ActivityCompat
            .checkSelfPermission(
                PomPomApplication.instance.currentActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) ==
                PackageManager.PERMISSION_GRANTED

        val coarseLocationPermission = ActivityCompat
            .checkSelfPermission(
                PomPomApplication.instance.currentActivity,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) ==
                PackageManager.PERMISSION_GRANTED

        if (!fineLocationPermission || !coarseLocationPermission) {
            ActivityCompat.requestPermissions(
                PomPomApplication.instance.currentActivity,
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ), 1
            )
        }
    }

    private fun initObserve(){
        isUpdateObservable.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                if(isUpdateObservable.get()) {
                    Log.e("Location", "Start location update")
                    locationClient.requestLocationUpdates(
                        locationRequest,
                        locationCallback,
                        Looper.getMainLooper()
                    )
                }
            }
        })

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
            isUpdateObservable.set(false)
        }
    }


}