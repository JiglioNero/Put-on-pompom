package jiglionero.android.app.putonpompom.domain.forecast

import jiglionero.android.app.putonpompom.domain.room.CloudsEntity


data class Clouds(
    val all: Int = 0
){
    fun toEntity(): CloudsEntity{
        return CloudsEntity().apply {
            this.all = this@Clouds.all
        }
    }
}