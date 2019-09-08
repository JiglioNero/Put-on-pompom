package jiglionero.android.app.putonpompom.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RestModule {
    @Provides
    fun retrofit(gSonFactory: GsonConverterFactory, client: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gSonFactory)
            .client(client)
            .build()
    }

    @Provides
    fun gSonFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun httpInterceptor(): HttpLoggingInterceptor {
        var interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides
    fun httpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }
}