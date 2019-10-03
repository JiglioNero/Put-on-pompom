package jiglionero.android.app.putonpompom.domain.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(foreignKeys = arrayOf(
    ForeignKey(entity = CloudsEntity::class, parentColumns = ["id"], childColumns = ["cloudsId"], onDelete = CASCADE),
    ForeignKey(entity = MainEntity::class, parentColumns = ["id"], childColumns = ["mainId"], onDelete = CASCADE),
    ForeignKey(entity = SysEntity::class, parentColumns = ["id"], childColumns = ["sysId"], onDelete = CASCADE),
    ForeignKey(entity = WindEntity::class, parentColumns = ["id"], childColumns = ["windId"], onDelete = CASCADE)
))
class OneWeatherEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var cloudsId: Int = 0
    var dt: Int = 0
    var mainId: Int = 0
    var sysId: Int = 0
    var windId: Int = 0
}