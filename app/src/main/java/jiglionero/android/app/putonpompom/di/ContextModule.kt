package jiglionero.android.app.putonpompom.di

import android.app.NotificationManager
import android.content.Context
import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.PomPomApplication
import javax.inject.Singleton

@Module
class ContextModule {
    @Provides
    fun getContext(): Context{
        return PomPomApplication.instance
    }

    @Singleton
    @Provides
    fun getNotificationManager(): NotificationManager{
        return PomPomApplication.instance.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
}