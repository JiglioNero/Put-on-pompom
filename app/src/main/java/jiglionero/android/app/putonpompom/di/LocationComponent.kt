package jiglionero.android.app.putonpompom.di

import dagger.Component
import jiglionero.android.app.putonpompom.service.LocationService
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(LocationModule::class, ContextModule::class, WeatherAPIModule::class, RestModule::class))
interface LocationComponent {
    fun inject(service: LocationService)
}