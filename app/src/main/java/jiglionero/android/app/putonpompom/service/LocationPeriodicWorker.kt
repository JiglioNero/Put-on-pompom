package jiglionero.android.app.putonpompom.service

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.data.DataNode
import javax.inject.Inject


class LocationPeriodicWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    @Inject lateinit var dataNode: DataNode
    @Inject lateinit var notificationManager: NotificationManager

    init {
        PomPomApplication.instance.weatherComponent.inject(this)
    }

    override fun doWork(): Result {
        dataNode.tryToStartUpdate()

        val noti = Notification.Builder(PomPomApplication.instance)
            .setContentTitle(PomPomApplication.instance.getString(R.string.app_name))
            .setContentText(PomPomApplication.instance.getString(R.string.weather_upadete_notify))
            .setSmallIcon(R.drawable.deg_icon)
            .build()

        notificationManager.notify(0,noti)

        return Result.success()
    }

}