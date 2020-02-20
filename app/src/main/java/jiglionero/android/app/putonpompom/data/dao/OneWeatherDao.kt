package jiglionero.android.app.putonpompom.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import jiglionero.android.app.putonpompom.domain.forecast.WeatherCurrent
import java.util.*

@Dao
interface OneWeatherDao {
    @Query("SELECT * FROM WeatherCurrent ORDER BY WeatherCurrent.dt ASC")
    fun getAll(): LiveData<List<WeatherCurrent>>

    @Query("SELECT * FROM WeatherCurrent WHERE dt > :dateTime ORDER BY WeatherCurrent.dt ASC")
    fun getAllAfterDate(dateTime: Long): LiveData<List<WeatherCurrent>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entitys: List<WeatherCurrent>): Array<Long>

    @Delete
    fun delete(entity: WeatherCurrent)
}