package jiglionero.android.app.putonpompom.di

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.data.WeatherCaller
import jiglionero.android.app.putonpompom.service.LocationPeriodicWorker
import java.util.concurrent.TimeUnit


@Module
class LocationModule {
    @Provides
    fun createLocationRequest(): LocationRequest{
        return LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }

    @Provides
    fun getLocationCallback(weatherCaller: WeatherCaller): LocationCallback{
        return object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult ?: return
                for (location in locationResult.locations){
                    weatherCaller.location.value = location
                }
            }
        }
    }

    @Provides
    fun getLocationPeriodicWorker(): PeriodicWorkRequest{
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        return PeriodicWorkRequest.Builder(LocationPeriodicWorker::class.java, 60, TimeUnit.MINUTES, 30, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .addTag("location")
            .build()
    }

    @Provides
    fun getLocationClient(context: Context): FusedLocationProviderClient{
        return FusedLocationProviderClient(context)
    }
}