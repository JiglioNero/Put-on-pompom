package jiglionero.android.app.putonpompom.service

import android.Manifest
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import androidx.core.app.ActivityCompat
import androidx.core.app.ServiceCompat
import androidx.core.net.ConnectivityManagerCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import jiglionero.android.app.putonpompom.PomPomApplication
import java.util.*
import javax.inject.Inject

class LocationService : LifecycleService() {

    @Inject
    lateinit var locationCallback: LocationCallback
    @Inject
    lateinit var locationRequest: LocationRequest
    @Inject
    lateinit var locationClient: FusedLocationProviderClient
    var isConnectedToNetwork = MutableLiveData<Boolean?>()

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        PomPomApplication.instance.weatherComponent.inject(this)
        val connectivityManager =
            PomPomApplication.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        isConnectedToNetwork = MutableLiveData(
            ConnectivityManagerCompat.getNetworkInfoFromBroadcast(
                connectivityManager,
                Intent()
            )?.isConnectedOrConnecting
        )
        isConnectedToNetwork
            .observe(this
                , Observer {
                    it?.let {
                        if (it) {
                            if (isGetPermission()) {
                                    startLocationUpdates()
                            }
                        } else {
                            stopLocationUpdates()
                        }
                    }
                })
        tryToGetAccess()
        isConnectedToNetwork.value?.let {
            if (isGetPermission()) {
                if (it) {
                    startLocationUpdates()
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isConnectedToNetwork.value!!) {
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

    private fun stopLocationUpdates() {
        locationClient.removeLocationUpdates(locationCallback)
    }

    private fun startLocationUpdates() {
        locationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

}
