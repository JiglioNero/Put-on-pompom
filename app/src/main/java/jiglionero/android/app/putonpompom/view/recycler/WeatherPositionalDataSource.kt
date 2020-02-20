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
        var size = 0
        Log.e("Data Source", dataNode.forecastList.value.toString())
        if(dataNode.forecastList.value != null) {
            var loadSize = params.requestedLoadSize
            val listSize = dataNode.forecastList.value!!.size
            if(params.requestedStartPosition + loadSize > listSize){
                loadSize = listSize - params.requestedStartPosition
            }
            result =
                dataNode.forecastList.value!!.subList(
                    params.requestedStartPosition,
                    params.requestedStartPosition + loadSize
                )
            size = listSize
        }
        if(params.placeholdersEnabled){
            callback.onResult(result, params.requestedStartPosition, size)
        }
        else {
            callback.onResult(result, params.requestedStartPosition)
        }
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<OneWeather>) {
        Log.d(
            ContentValues.TAG,
            "loadRange, startPosition = " + params.startPosition + ", loadSize = " + params.loadSize
        )
        var result: List<OneWeather> = listOf()
        if(dataNode.forecastList.value != null) {
            var loadSize = params.loadSize
            val listSize = dataNode.forecastList.value!!.size
            if(params.startPosition + loadSize > listSize){
                loadSize = listSize - params.startPosition
            }
            result =
                dataNode.forecastList.value!!.subList(
                    params.startPosition,
                    params.startPosition + loadSize
                )
        }
        callback.onResult(result)
    }

}