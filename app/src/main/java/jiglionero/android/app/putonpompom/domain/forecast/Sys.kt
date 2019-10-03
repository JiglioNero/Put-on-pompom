package jiglionero.android.app.putonpompom.domain.forecast

import jiglionero.android.app.putonpompom.domain.room.SysEntity

data class Sys(
    val pod: String = ""
){
    fun toEntity():SysEntity{
        return SysEntity().apply {
            pod = this@Sys.pod
        }
    }
}