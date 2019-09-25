package jiglionero.android.app.putonpompom.domain.location

data class TimeZone(
    val Code: String = "",
    val GmtOffset: Int = 0,
    val IsDaylightSaving: Boolean = false,
    val Name: String = "",
    val NextOffsetChange: Any = Any()
)