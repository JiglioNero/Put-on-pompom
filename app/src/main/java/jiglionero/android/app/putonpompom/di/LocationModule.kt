package jiglionero.android.app.putonpompom.di

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.data.WeatherCaller

@Module
class LocationModule {
    @Provides
    fun createLocationRequest(): LocationRequest{
        return LocationRequest.create().apply {
            interval = 1000 * 60 * 10 //10 mins
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
    fun getLocationClient(context: Context): FusedLocationProviderClient{
        return FusedLocationProviderClient(context)
    }
}