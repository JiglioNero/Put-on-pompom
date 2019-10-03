package jiglionero.android.app.putonpompom.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import jiglionero.android.app.putonpompom.domain.room.SysEntity

@Dao
interface SysDao {
    @Query("SELECT * FROM SysEntity")
    fun getAll(): List<SysEntity>

    @Insert
    fun insert(entity: SysEntity)

    @Delete
    fun delete(entity: SysEntity)
}