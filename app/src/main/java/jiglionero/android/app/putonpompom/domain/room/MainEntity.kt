package jiglionero.android.app.putonpompom.domain.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class MainEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var humidity: Int = 0
    var pressure: Double = 0.0
    var temp: Double = 0.0
    var temp_max: Double = 0.0
    var temp_min: Double = 0.0
}