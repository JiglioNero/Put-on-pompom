package jiglionero.android.app.putonpompom.di

import dagger.Component
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.model.WeatherPerHourForecastViewModel
import jiglionero.android.app.putonpompom.model.WeatherViewModel
import jiglionero.android.app.putonpompom.service.LocationPeriodicWorker
import javax.inject.Singleton

@Singleton
@Component(modules = [
    WeatherAPIModule::class,
    RestModule::class,
    ContextModule::class,
    LocationModule::class,
    BackgroundModule::class,
    DataModule::class,
    RecyclerModule::class])
interface WeatherComponent {
    fun inject(weatherViewModel: WeatherViewModel)
    fun inject(locationWorker: LocationPeriodicWorker)
    fun inject(pomPomApplication: PomPomApplication)
    fun inject(weatherPerHourForecastViewModel: WeatherPerHourForecastViewModel)
}