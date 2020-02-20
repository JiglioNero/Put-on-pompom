package jiglionero.android.app.putonpompom.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.RoomDatabase
import jiglionero.android.app.putonpompom.data.dao.OneWeatherDao
import jiglionero.android.app.putonpompom.domain.forecast.WeatherCurrent
import java.util.*

@Database(entities = arrayOf(WeatherCurrent::class), version = 1)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun oneWeatherDao(): OneWeatherDao
    
    fun getAllCurrentWeathersSortedByDate(): LiveData<List<WeatherCurrent>>{
        Log.i("Database","getAllCurrentWeathersSortedByDate()")
        return oneWeatherDao().getAll()
    }

    fun getAllActualCurrentWeathersSortedByDate(): LiveData<List<WeatherCurrent>>{
        Log.i("Database","getAllActualCurrentWeathersSortedByDate()")
        return oneWeatherDao().getAllAfterDate(Date().time/1000)
    }

    @Synchronized fun saveAllCurrentWeathers(weatherCurrentList: List<WeatherCurrent>){
        Log.i("Database","saveAllCurrentWeathers()")
        this.clearAllTables()
        oneWeatherDao().insert(weatherCurrentList)
    }

}