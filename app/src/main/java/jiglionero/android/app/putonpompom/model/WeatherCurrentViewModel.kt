package jiglionero.android.app.putonpompom.model



class WeatherCurrentViewModel : WeatherViewModel() {
    override fun initObserveResponse() {
        dataNode.weatherApiResponseCurrent.observeForever{
            weatherApiResponse.set(it)
        }
    }

    override fun initObservable() {
        val weatherApiResponseCurrent = dataNode.weatherApiResponseCurrent.value
        weatherApiResponse.set(weatherApiResponseCurrent)
        oneWeatherList.add(weatherApiResponseCurrent)
    }
}
