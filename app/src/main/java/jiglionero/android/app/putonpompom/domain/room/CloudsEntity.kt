package jiglionero.android.app.putonpompom.domain.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CloudsEntity {
    var all: Int = 0
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}