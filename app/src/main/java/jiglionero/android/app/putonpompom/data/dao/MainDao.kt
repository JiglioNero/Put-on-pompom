package jiglionero.android.app.putonpompom.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import jiglionero.android.app.putonpompom.domain.room.MainEntity

@Dao
interface MainDao {
    @Query("SELECT * FROM MainEntity")
    fun getAll(): List<MainEntity>

    @Insert
    fun insert(entity: MainEntity)

    @Delete
    fun delete(entity: MainEntity)
}