package jiglionero.android.app.putonpompom.data

import android.content.Context
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class WeatherWorkerController(context: Context, workerParams: WorkerParameters) :Worker(context,
    workerParams)
{
    override fun doWork(): Result {
        val request = inputData.keyValueMap["request"] as OneTimeWorkRequest
        var result = WorkManager.getInstance().enqueue(request)
        var status = WorkManager.getInstance().getWorkInfoById(request.id)
        while (true){
            Thread.sleep(5000)
            status.addListener({

            }, {

            })
        }


    }
}