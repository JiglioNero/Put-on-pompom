package jiglionero.android.app.putonpompom.domain.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class WindEntity {
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
    val deg: Double = 0.0
    val speed: Double = 0.0
}