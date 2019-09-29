package jiglionero.android.app.putonpompom.view.recycler

import android.content.ContentValues
import android.util.Log
import androidx.paging.PositionalDataSource
import jiglionero.android.app.putonpompom.data.DataNode
import jiglionero.android.app.putonpompom.domain.OneWeather

class WeatherPositionalDataSource(private val dataNode: DataNode) : PositionalDataSource<OneWeather>() {

    override fun loadInitial(
        params: LoadInitialParams,
        callback: LoadInitialCallback<OneWeather>
    ) {
        Log.d(
            ContentValues.TAG, "loadInitial, requestedStartPosition = " + params.requestedStartPosition +
                    ", requestedLoadSize = " + params.requestedLoadSize
        )
        var result: List<OneWeather> = listOf()
        if(dataNode.weatherApiResponseForecast5D3H.value == null) {
            result =
                dataNode.weatherApiResponseForecast5D3H.value?.getOneWeatherList()?.subList(
                    params.requestedStartPosition,
                    params.requestedLoadSize
                )!!
        }
        if(params.placeholdersEnabled){
            callback.onResult(result, 0, result.count())
        }
        else {
            callback.onResult(result, 0)
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<OneWeather>) {
        Log.d(
            ContentValues.TAG,
            "loadRange, startPosition = " + params.startPosition + ", loadSize = " + params.loadSize
        )
        var result: List<OneWeather> = listOf()
        if(dataNode.weatherApiResponseForecast5D3H.value == null) {
            result =
                dataNode.weatherApiResponseForecast5D3H.value?.getOneWeatherList()?.subList(
                    params.startPosition,
                    params.loadSize
                )!!
        }
        callback.onResult(result)
    }

}