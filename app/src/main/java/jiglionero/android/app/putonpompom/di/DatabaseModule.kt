package jiglionero.android.app.putonpompom.di

import android.content.Context
import androidx.room.Room
import dagger.Provides
import jiglionero.android.app.putonpompom.data.WeatherDatabase

class DatabaseModule {
    @Provides
    fun getDatabase(context: Context): WeatherDatabase{
        return Room.databaseBuilder(context, WeatherDatabase::class.java, "WeatherDatabase").build()
    }
}