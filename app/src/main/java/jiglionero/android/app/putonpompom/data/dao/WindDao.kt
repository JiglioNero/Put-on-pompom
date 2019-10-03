package jiglionero.android.app.putonpompom.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import jiglionero.android.app.putonpompom.domain.room.WindEntity

@Dao
interface WindDao {
    @Query("SELECT * FROM WindEntity")
    fun getAll(): List<WindEntity>

    @Insert
    fun insert(entity: WindEntity)

    @Delete
    fun delete(entity: WindEntity)
}