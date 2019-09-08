package jiglionero.android.app.putonpompom.view.model

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.domain.WeatherApiResponse
import javax.inject.Inject


class WeatherViewModel : ViewModel() {
    @Inject
    lateinit var weatherResponse: ObservableField<WeatherApiResponse?>

    init {
        PomPomApplication.weatherComponent.inject(this)
    }

}
