package jiglionero.android.app.putonpompom.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import jiglionero.android.app.putonpompom.domain.room.WeatherEntity

@Dao
interface WeatherDao {
    @Query("SELECT * FROM WeatherEntity")
    fun getAll(): List<WeatherEntity>

    @Insert
    fun insert(entity: WeatherEntity)

    @Delete
    fun delete(entity: WeatherEntity)
}