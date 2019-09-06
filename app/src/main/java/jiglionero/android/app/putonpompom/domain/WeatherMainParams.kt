package jiglionero.android.app.putonpompom.domain

import com.google.gson.annotations.SerializedName

class WeatherMainParams(
    @SerializedName("temp") var tempF: Float,
    @SerializedName("pressure") var pressure: Int,
    @SerializedName("humidity") var humidity: Int,
    @SerializedName("temp_min") var tempFMin: Float,
    @SerializedName("temp_max") var tempFMax: Float
)