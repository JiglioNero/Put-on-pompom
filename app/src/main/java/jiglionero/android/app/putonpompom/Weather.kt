package jiglionero.android.app.putonpompom

import javax.inject.Inject

class Weather(@Inject var description: String,
              @Inject var tempF: Float,
              @Inject var tempFMin: Float,
              @Inject var tempFMax: Float,
              @Inject var pressure: Int,
              @Inject var humidity: Int,
              @Inject var windSpeed: Float,
              @Inject var windDeg: Float,
              @Inject var clouds: Int) {


}