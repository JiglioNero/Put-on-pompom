package jiglionero.android.app.putonpompom.data

import androidx.room.Database
import androidx.room.RoomDatabase
import jiglionero.android.app.putonpompom.data.dao.*
import jiglionero.android.app.putonpompom.domain.room.*

@Database(entities = arrayOf(
    CloudsEntity::class,
    MainEntity::class,
    OneWeatherEntity::class,
    SysEntity::class,
    WeatherEntity::class,
    WindEntity::class), version = 1)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun cloudsDao(): CloudsDao
    abstract fun mainDao(): MainDao
    abstract fun oneWeatherDao(): OneWeatherDao
    abstract fun sysDao(): SysDao
    abstract fun weatherDao(): WeatherDao
    abstract fun windDao(): WindDao
    abstract fun fullWeatherDao(): FullWeatherDao
}