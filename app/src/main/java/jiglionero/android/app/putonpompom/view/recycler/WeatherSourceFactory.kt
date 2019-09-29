package jiglionero.android.app.putonpompom.view.recycler

import androidx.paging.DataSource
import jiglionero.android.app.putonpompom.data.DataNode
import jiglionero.android.app.putonpompom.domain.OneWeather

class WeatherSourceFactory(private val dataNode: DataNode) : DataSource.Factory<Int, OneWeather>() {

    override fun create(): DataSource<Int, OneWeather> {
        return WeatherPositionalDataSource(dataNode)
    }
}