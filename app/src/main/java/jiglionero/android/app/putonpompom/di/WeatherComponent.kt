package jiglionero.android.app.putonpompom.di

import dagger.Component
import jiglionero.android.app.putonpompom.service.LocationService
import jiglionero.android.app.putonpompom.view.viewmodel.WeatherViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(WeatherAPIModule::class, RestModule::class, ContextModule::class, LocationModule::class))
interface WeatherComponent {
    fun inject(weatherViewModel: WeatherViewModel)
    fun inject(locationService: LocationService)
}