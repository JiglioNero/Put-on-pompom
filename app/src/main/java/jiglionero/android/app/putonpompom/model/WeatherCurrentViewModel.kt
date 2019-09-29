package jiglionero.android.app.putonpompom.model



class WeatherCurrentViewModel : WeatherViewModel() {
    override fun initObserveResponse() {
        weatherCaller.weatherApiResponseCurrent.observeForever{
            weatherApiResponse.set(it)
        }
    }

    override fun initObservable() {
        val weatherApiResponseCurrent = weatherCaller.weatherApiResponseCurrent.value
        weatherApiResponse.set(weatherApiResponseCurrent)
        oneWeatherList.add(weatherApiResponseCurrent)
    }


}
