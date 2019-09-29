package jiglionero.android.app.putonpompom.di

import android.content.Context
import androidx.databinding.ListChangeRegistry
import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.PomPomApplication

@Module
class ContextModule {
    @Provides
    fun getContext(): Context{
        return PomPomApplication.instance
    }

    @Provides
    fun getlistChangeRegistry(): ListChangeRegistry{
        return ListChangeRegistry()
    }
}