package jiglionero.android.app.putonpompom.data

import android.content.res.Resources
import jiglionero.android.app.putonpompom.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkWeatherService {
    private val baseUrl = Resources.getSystem().getString(R.string.base_weather_url)
    private var retrofit: Retrofit
    private var instance: NetworkWeatherService?=null
    get() {
        if(field == null){
            field = NetworkWeatherService()
        }
        return field
    }

    init {
        var interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        var clientBuilder = OkHttpClient.Builder()
        clientBuilder.addInterceptor(interceptor)

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(clientBuilder.build())
            .build()
    }
}