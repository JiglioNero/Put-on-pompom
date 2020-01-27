package jiglionero.android.app.putonpompom.data

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
        return oneWeatherDao().getAll()
    }

    fun buildToActual(clist: List<WeatherCurrent>): ArrayList<WeatherCurrent>{
        val nowDate = Date()
        val newList = arrayListOf<WeatherCurrent>()
        newList.addAll(clist)
        if (newList.size >= 2) {
            var j = 0
            for (i in 0 until clist.size - 1) {
                if (nowDate.before(Date(clist[i + 1].getDate()))) {
                    j+=1
                    break
                } else {
                    newList.removeAt(j)
                }
            }
        }
        return newList
    }

    @Synchronized fun saveAllCurrentWeathers(weatherCurrentList: List<WeatherCurrent>){
        this.clearAllTables()
        oneWeatherDao().insert(weatherCurrentList)
    }

}