package jiglionero.android.app.putonpompom.domain.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class SysEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var pod: String = ""
}