package jiglionero.android.app.putonpompom.view.model


import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.OpenWeatherApi
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import javax.inject.Inject


class WeatherViewModel : ViewModel() {

    var weatherResponse: ObservableField<WeatherApiResponse?> = ObservableField(WeatherApiResponse())
    @Inject lateinit var weatherApi: OpenWeatherApi

        init {
            PomPomApplication.weatherComponent.inject(this)
            /*weatherCall.enqueue(object :Callback<WeatherApiResponse>{
                override fun onFailure(call: Call<WeatherApiResponse>, t: Throwable) {
                    Toast.makeText(PomPomApplication.instance, "Request field!", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<WeatherApiResponse>,
                    response: Response<WeatherApiResponse>
                ) {
                    weatherResponse.set(response.body())
                }

            })*/

            Thread(Runnable { weatherResponse.set(weatherCall.execute().body()) }).start()
        }

}
