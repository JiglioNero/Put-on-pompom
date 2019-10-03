package jiglionero.android.app.putonpompom.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.R

@Module
class PreferencesModule {
    @Provides
    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(context.resources.getString(R.string.config_file_name), Context.MODE_PRIVATE)
    }
}