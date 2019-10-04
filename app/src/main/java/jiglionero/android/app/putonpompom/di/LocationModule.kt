package jiglionero.android.app.putonpompom.di

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import dagger.Module
import dagger.Provides


@Module
class LocationModule {
    @Provides
    fun createLocationRequest(): LocationRequest{
        return LocationRequest.create().apply {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }

    @Provides
    fun getLocationClient(context: Context): FusedLocationProviderClient{
        return FusedLocationProviderClient(context)
    }
}