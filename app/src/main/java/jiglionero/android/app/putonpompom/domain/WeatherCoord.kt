package jiglionero.android.app.putonpompom.domain

import com.google.gson.annotations.SerializedName

class WeatherCoord (
    @SerializedName("lon") var lon: Float = 0F,
    @SerializedName("lat") var lat: Float = 0F
)