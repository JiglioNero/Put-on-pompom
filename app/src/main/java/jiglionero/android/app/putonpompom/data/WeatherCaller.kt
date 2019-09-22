package jiglionero.android.app.putonpompom.data

import android.content.Intent
import android.location.Location
import androidx.lifecycle.MutableLiveData
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import jiglionero.android.app.putonpompom.service.LocationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherCaller(weatherApi: OpenWeatherApi){

    private val weatherApi = weatherApi
    var location: MutableLiveData<Location> = MutableLiveData()
    var weatherApiResponse: MutableLiveData<WeatherApiResponse> = MutableLiveData()

    init {
        location.observeForever {
            weatherApi.getCurrentWeather(it.latitude, it.longitude).enqueue(object :Callback<WeatherApiResponse>{
                override fun onResponse(
                    call: Call<WeatherApiResponse>,
                    response: Response<WeatherApiResponse>
                ) {
                    weatherApiResponse.value = response.body()
                }

                override fun onFailure(call: Call<WeatherApiResponse>, t: Throwable) {

                }

            })
        }

        PomPomApplication.instance.startService(Intent(PomPomApplication.instance, LocationService::class.java))
    }



}