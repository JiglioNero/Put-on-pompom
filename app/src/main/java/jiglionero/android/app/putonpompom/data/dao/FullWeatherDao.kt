package jiglionero.android.app.putonpompom.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import jiglionero.android.app.putonpompom.domain.forecast.WeatherCurrent

@Dao
interface FullWeatherDao{
    @Transaction
    @Query("SELECT OneWeatherEntity.dt" +
           /* " CloudsEntity.`all`," +
            " MainEntity.humidity," +
            " MainEntity.`temp`," +
            " MainEntity.pressure," +
            " MainEntity.temp_max," +
            " MainEntity.temp_min," +
            " SysEntity.pod," +
            " WeatherEntity.description," +
            " WeatherEntity.main," +
            " WeatherEntity.icon," +
            " WindEntity.deg," +
            " WindEntity.speed" +*/
            " FROM OneWeatherEntity"
            /*" CloudsEntity, MainEntity, SysEntity, WeatherEntity, WindEntity" */)
    fun getAllForecastWeathers(): List<WeatherCurrent>
}