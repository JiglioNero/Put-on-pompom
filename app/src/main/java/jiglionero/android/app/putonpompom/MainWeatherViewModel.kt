package jiglionero.android.app.putonpompom

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import jiglionero.android.app.putonpompom.domain.Weather

class MainWeatherViewModel : ViewModel() {
    private var weather: ObservableField<Weather>? = null
    get() {
        if (field==null){

        }
        return field
    }

    /*fun getWeather():Weather{

    }*/
}
