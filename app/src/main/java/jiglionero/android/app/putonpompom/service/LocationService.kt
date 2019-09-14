package jiglionero.android.app.putonpompom.service

import android.Manifest
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.os.IBinder
import android.os.Looper
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import jiglionero.android.app.putonpompom.PomPomApplication
import javax.inject.Inject

class LocationService : Service() {

    @Inject lateinit var locationCallback: LocationCallback
    @Inject lateinit var locationRequest: LocationRequest
    @Inject lateinit var locationClient: FusedLocationProviderClient

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        PomPomApplication.instance.locationComponent.inject(this)

        val permissionAccessCoarseLocationApproved = ActivityCompat
            .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED

        val backgroundLocationPermissionApproved = ActivityCompat
            .checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) ==
                PackageManager.PERMISSION_GRANTED

        if (backgroundLocationPermissionApproved && permissionAccessCoarseLocationApproved){
            startLocationUpdates()
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopLocationUpdates()
    }

    fun stopLocationUpdates() {
        locationClient.removeLocationUpdates(locationCallback)
    }

    fun startLocationUpdates() {
        locationClient.requestLocationUpdates(locationRequest,
            locationCallback,
            Looper.getMainLooper())
    }
}
