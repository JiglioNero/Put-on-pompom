package jiglionero.android.app.putonpompom.di

import dagger.Component
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.model.WeatherCurrentViewModel
import jiglionero.android.app.putonpompom.model.WeatherViewModel
import jiglionero.android.app.putonpompom.service.LocationPeriodicWorker
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(WeatherAPIModule::class, RestModule::class, ContextModule::class, LocationModule::class))
interface WeatherComponent {
    fun inject(weatherViewModel: WeatherViewModel)
    fun inject(locationWorker: LocationPeriodicWorker)
    fun inject(pomPomApplication: PomPomApplication)
}