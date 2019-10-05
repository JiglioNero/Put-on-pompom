package jiglionero.android.app.putonpompom.di

import dagger.Component
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.model.WeatherCurrentViewModel
import jiglionero.android.app.putonpompom.model.WeatherPerHourForecastViewModel
import jiglionero.android.app.putonpompom.service.LocationPeriodicWorker
import jiglionero.android.app.putonpompom.view.activity.MainActivity
import jiglionero.android.app.putonpompom.view.fragment.CurrentFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [
    WeatherAPIModule::class,
    RestModule::class,
    ContextModule::class,
    LocationModule::class,
    BackgroundModule::class,
    DataModule::class,
    RecyclerModule::class,
    PreferencesModule::class])
interface WeatherComponent {
    fun inject(weatherViewModel: WeatherCurrentViewModel)
    fun inject(weatherPerHourForecastViewModel: WeatherPerHourForecastViewModel)
    fun inject(currentFragment: CurrentFragment)
    fun inject(locationWorker: LocationPeriodicWorker)
    fun inject(pomPomApplication: PomPomApplication)
    fun inject(mainActivity: MainActivity)
}