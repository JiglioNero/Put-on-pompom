package jiglionero.android.app.putonpompom.domain

import com.google.gson.annotations.SerializedName


class Weather(
    @SerializedName("id") var id: Long = 0,
    @SerializedName("main") var main: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("icon") var icon: String = ""
)