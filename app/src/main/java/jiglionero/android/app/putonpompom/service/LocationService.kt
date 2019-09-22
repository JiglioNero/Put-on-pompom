package jiglionero.android.app.putonpompom.service

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LifecycleService
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.data.NetworkUtil
import jiglionero.android.app.putonpompom.receiver.NetworkChangeReceiver
import javax.inject.Inject

class LocationService : LifecycleService() {

    @Inject
    lateinit var locationCallback: LocationCallback
    @Inject
    lateinit var locationRequest: LocationRequest
    @Inject
    lateinit var locationClient: FusedLocationProviderClient
    var isOnUpdates = false

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        PomPomApplication.instance.weatherComponent.inject(this)
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    startLocationUpdates()
                }
                override fun onLost(network: Network?) {
                    stopLocationUpdates()
                }
            })
        }
        else {
            registerReceiver(
                NetworkChangeReceiver(),
                IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
            )
        }
        tryToGetAccess()
        if(isGetPermission() && !isOnUpdates && NetworkUtil.getConnectivityStatusString(this) != NetworkUtil.NETWORK_STATUS_NOT_CONNECTED){
            startLocationUpdates()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(isOnUpdates) {
            stopLocationUpdates()
        }
    }

    private fun isGetPermission(): Boolean {
        if (ActivityCompat
                .checkSelfPermission(
                    PomPomApplication.instance.currentActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) ==
            PackageManager.PERMISSION_GRANTED &&
            ActivityCompat
                .checkSelfPermission(
                    PomPomApplication.instance.currentActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }
        return false
    }

    private fun tryToGetAccess() {
        val fineLocationPermission = ActivityCompat
            .checkSelfPermission(
                PomPomApplication.instance.currentActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) ==
                PackageManager.PERMISSION_GRANTED

        val coarseLocationPermission = ActivityCompat
            .checkSelfPermission(
                PomPomApplication.instance.currentActivity,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) ==
                PackageManager.PERMISSION_GRANTED

        if (!fineLocationPermission || !coarseLocationPermission) {
            ActivityCompat.requestPermissions(
                PomPomApplication.instance.currentActivity,
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ), 1
            )
        }
    }

    fun stopLocationUpdates() {
        if(isOnUpdates) {
            Log.e("Location", "Stop location update")
            locationClient.removeLocationUpdates(locationCallback)
            isOnUpdates = false
        }
    }

    fun startLocationUpdates() {
        if(!isOnUpdates) {
            Log.e("Location", "Start location update")
            locationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
            isOnUpdates = true
        }
    }

}
