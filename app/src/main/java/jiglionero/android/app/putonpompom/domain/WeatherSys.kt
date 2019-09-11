package jiglionero.android.app.putonpompom.domain

import com.google.gson.annotations.SerializedName

class WeatherSys(
    @SerializedName("type") var type: Int = 0,
    @SerializedName("id") var id: Long = 0,
    @SerializedName("message") var message: Float = 0F,
    @SerializedName("country") var country: String = "",
    @SerializedName("sunrise") var sunRise: Long = 0,
    @SerializedName("sunset") var sunSet: Long = 0
)