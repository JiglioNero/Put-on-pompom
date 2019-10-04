package jiglionero.android.app.putonpompom.di

import android.content.Context
import androidx.room.Room
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.data.DataNode
import jiglionero.android.app.putonpompom.data.WeatherDatabase
import jiglionero.android.app.putonpompom.data.network.OpenWeatherApi
import javax.inject.Singleton

@Module
class DataModule{
    @Singleton
    @Provides
    fun getWeatherCaller(openWeatherApi: OpenWeatherApi,
                         database: WeatherDatabase,
                         locationRequest: LocationRequest,
                         locationClient: FusedLocationProviderClient
    ): DataNode {
        return DataNode(openWeatherApi,
            database,
            locationRequest,
            locationClient)
    }

    @Singleton
    @Provides
    fun getDatabase(context: Context): WeatherDatabase{
        return Room.databaseBuilder(context, WeatherDatabase::class.java, "WeatherDatabase")
            .build()
    }
}