package jiglionero.android.app.putonpompom.domain

import com.google.gson.annotations.SerializedName

class WeatherSys(
    @SerializedName("type") var type: Int,
    @SerializedName("id") var id: Long,
    @SerializedName("message") var message: Int,
    @SerializedName("country") var country: String,
    @SerializedName("sunrise") var sunRise: Long,
    @SerializedName("sunset") var sunSet: Long
)