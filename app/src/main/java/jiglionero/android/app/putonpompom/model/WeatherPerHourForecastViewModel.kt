package jiglionero.android.app.putonpompom.model

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.DataNode
import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.view.recycler.WeatherAdapter
import javax.inject.Inject

class WeatherPerHourForecastViewModel : ViewModel() {
    @Inject
    lateinit var weatherAdapter: WeatherAdapter
    @Inject
    lateinit var pagedList: LiveData<PagedList<OneWeather>>
    @Inject
    lateinit var dataNode:DataNode

    init {
        PomPomApplication.instance.weatherComponent.inject(this)
        weatherAdapter.submitList(pagedList.value)
    }

    fun initObserveResponse(lifeCycleOwner: LifecycleOwner) {
        dataNode.weatherApiResponseForecast5D3H.observe(lifeCycleOwner, Observer{
            pagedList.value?.dataSource?.invalidate()
        })

        pagedList.observe(lifeCycleOwner, Observer {
            weatherAdapter.submitList(it)
        })
    }
}
