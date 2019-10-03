package jiglionero.android.app.putonpompom.di

import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.data.DataNode
import jiglionero.android.app.putonpompom.data.OpenWeatherApi
import jiglionero.android.app.putonpompom.data.WeatherDatabase
import javax.inject.Singleton

@Module
class DataModule{
    @Singleton
    @Provides
    fun getWeatherCaller(openWeatherApi: OpenWeatherApi, database: WeatherDatabase): DataNode {
        return DataNode(openWeatherApi, database)
    }
}