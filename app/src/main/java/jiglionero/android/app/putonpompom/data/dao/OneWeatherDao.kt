package jiglionero.android.app.putonpompom.data.dao

import androidx.room.*
import jiglionero.android.app.putonpompom.domain.room.OneWeatherEntity

@Dao
interface OneWeatherDao {
    @Query("SELECT * FROM OneWeatherEntity")
    fun getAll(): List<OneWeatherEntity>

    @Insert
    fun insert(oneWeatherEntity: OneWeatherEntity)

    @Delete
    fun delete(oneWeatherEntity: OneWeatherEntity)
}