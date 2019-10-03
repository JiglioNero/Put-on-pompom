package jiglionero.android.app.putonpompom.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import jiglionero.android.app.putonpompom.domain.room.CloudsEntity

@Dao
interface CloudsDao {
    @Query("SELECT * FROM CloudsEntity")
    fun getAll(): List<CloudsEntity>

    @Insert
    fun insert(entity: CloudsEntity)

    @Delete
    fun delete(entity: CloudsEntity)
}