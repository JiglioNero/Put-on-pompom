package jiglionero.android.app.putonpompom.domain

import com.google.gson.annotations.SerializedName

class WeatherWind(
    @SerializedName("speed") var speed: Float,
    @SerializedName("deg") var deg: Float
)