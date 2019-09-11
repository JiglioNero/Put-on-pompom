package jiglionero.android.app.putonpompom.domain

import com.google.gson.annotations.SerializedName

class WeatherMainParams(
    @SerializedName("temp") var tempF: Float = 0F,
    @SerializedName("pressure") var pressure: Float = 0F,
    @SerializedName("humidity") var humidity: Float = 0F,
    @SerializedName("temp_min") var tempFMin: Float = 0F,
    @SerializedName("temp_max") var tempFMax: Float = 0F
)