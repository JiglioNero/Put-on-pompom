package jiglionero.android.app.putonpompom.domain.weather.current

import androidx.annotation.NonNull

data class Temperature(
    @NonNull val Imperial: Imperial = Imperial(),
    @NonNull val Metric: Metric = Metric()
)