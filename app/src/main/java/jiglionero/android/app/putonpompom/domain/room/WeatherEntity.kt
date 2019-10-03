package jiglionero.android.app.putonpompom.domain.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = OneWeatherEntity::class, parentColumns = ["id"], childColumns = ["oneWeatherId"], onDelete = ForeignKey.CASCADE)
))
class WeatherEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var description: String = ""
    var icon: String = ""
    var main: String = ""
    var oneWeatherId: Int = 0
}