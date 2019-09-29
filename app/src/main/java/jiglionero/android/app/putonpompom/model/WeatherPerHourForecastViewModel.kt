package jiglionero.android.app.putonpompom.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.view.recycler.WeatherAdapter
import javax.inject.Inject

class WeatherPerHourForecastViewModel : ViewModel() {
    @Inject
    lateinit var weatherAdapter: WeatherAdapter
    @Inject
    lateinit var pagedList: LiveData<PagedList<OneWeather>>

    init {
        PomPomApplication.instance.weatherComponent.inject(this)
    }
}
