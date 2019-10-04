package jiglionero.android.app.putonpompom.di

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import dagger.Module
import dagger.Provides
import jiglionero.android.app.putonpompom.data.DataNode
import jiglionero.android.app.putonpompom.domain.OneWeather
import jiglionero.android.app.putonpompom.view.recycler.WeatherAdapter
import jiglionero.android.app.putonpompom.view.recycler.WeatherDiffUtilItemCallback
import jiglionero.android.app.putonpompom.view.recycler.WeatherSourceFactory
import java.util.concurrent.Executors

@Module
class RecyclerModule{

    @Provides
    fun getDataSourceFactory(dataNode: DataNode): WeatherSourceFactory {
        return WeatherSourceFactory(dataNode)
    }

    @Provides
    fun getPagedListConfig(): PagedList.Config{
        return PagedList.Config.Builder()
            .setPageSize(5)
            .setEnablePlaceholders(false)
            .build()
    }

    @Provides
    fun getLivePagedList(sourceFactory: WeatherSourceFactory, config: PagedList.Config) : LiveData<PagedList<OneWeather>> {
        return LivePagedListBuilder(sourceFactory, config)
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .build()
    }

    @Provides
    fun getWeatherDiffUtilItemCallback() : WeatherDiffUtilItemCallback {
        return WeatherDiffUtilItemCallback()
    }

    @Provides
    fun getAdapter(weatherDiffUtilItemCallback: WeatherDiffUtilItemCallback) : WeatherAdapter {
        return WeatherAdapter(weatherDiffUtilItemCallback)
    }
}