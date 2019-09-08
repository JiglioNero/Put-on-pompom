package jiglionero.android.app.putonpompom.di

import dagger.Component
import jiglionero.android.app.putonpompom.view.model.WeatherViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(WeatherAPIModule::class, RestModule::class))
interface WeatherComponent {
    fun inject(weatherViewModel: WeatherViewModel)
}