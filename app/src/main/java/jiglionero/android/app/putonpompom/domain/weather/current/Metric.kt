package jiglionero.android.app.putonpompom.domain.weather.current

import androidx.annotation.NonNull

data class Metric(
    @NonNull val Unit: String = "",
    @NonNull val UnitType: Int = 0,
    @NonNull val Value: Double = 0.0
)