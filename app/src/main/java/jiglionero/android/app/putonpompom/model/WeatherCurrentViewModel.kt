package jiglionero.android.app.putonpompom.model

import androidx.databinding.ObservableField
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.DataNode
import jiglionero.android.app.putonpompom.domain.OneWeather
import javax.inject.Inject


class WeatherCurrentViewModel : ViewModel() {
    @Inject
    lateinit var dataNode: DataNode
    var oneWeather: ObservableField<OneWeather> = ObservableField()

    init {
        PomPomApplication.instance.weatherComponent.inject(this)
        oneWeather.set(dataNode.current.value)

        OneWeather.degreesNameUse.observeForever{
            oneWeather.notifyChange()
        }
    }

    fun initObserveResponse(lifeCycleOwner: LifecycleOwner) {
        dataNode.current.observe(lifeCycleOwner, Observer {
            oneWeather.set(it)
        })
    }
}
