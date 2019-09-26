package jiglionero.android.app.putonpompom.service

import android.Manifest
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Looper
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R
import javax.inject.Inject

class LocationPeriodicWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    @Inject
    lateinit var locationCallback: LocationCallback
    @Inject
    lateinit var locationRequest: LocationRequest
    @Inject
    lateinit var locationClient: FusedLocationProviderClient

    init {
        PomPomApplication.instance.weatherComponent.inject(this)
    }

    override fun doWork(): Result {
        tryToGetAccess()
        if(isGetPermission()){
            startLocationUpdates()
        }

        val notificationManager =
            PomPomApplication.instance.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        notificationManager!!.notify(1,
            NotificationCompat.Builder(PomPomApplication.instance)
                .setSmallIcon(R.drawable.deg_icon)
                .setContentTitle("Title")
                .setContentText("Notification text")
                .build())
        return Result.success()
    }

    fun startLocationUpdates() {
        if(isGetPermission()) {
            Log.e("Location", "Start location update")
            locationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                Looper.getMainLooper()
            )
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

}