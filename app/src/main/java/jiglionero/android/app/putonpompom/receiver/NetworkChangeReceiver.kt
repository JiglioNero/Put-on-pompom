package jiglionero.android.app.putonpompom.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import jiglionero.android.app.putonpompom.data.NetworkUtil
import jiglionero.android.app.putonpompom.service.LocationService


class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val status = NetworkUtil.getConnectivityStatusString(context)
        if ("android.net.conn.CONNECTIVITY_CHANGE" == intent.action && context is LocationService) {
            if (status == NetworkUtil.NETWORK_STATUS_NOT_CONNECTED) {
                context.stopLocationUpdates()
            } else {
                context.startLocationUpdates()
            }
        }
    }
}