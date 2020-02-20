package jiglionero.android.app.putonpompom.di

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.service.LocationPeriodicWorker
import java.util.concurrent.TimeUnit

@Module
class BackgroundModule{
    @Provides
    fun getConstraintsLocationWorker():Constraints{
        return Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
    }

    @Provides
    fun getLocationPeriodicWorker(constraints: Constraints): PeriodicWorkRequest {
        return PeriodicWorkRequest.Builder(LocationPeriodicWorker::class.java, 5, TimeUnit.SECONDS)
            .setConstraints(constraints)
            .addTag("location")
            .build()
    }
}