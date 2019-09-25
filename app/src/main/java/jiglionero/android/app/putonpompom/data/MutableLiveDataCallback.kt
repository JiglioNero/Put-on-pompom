package jiglionero.android.app.putonpompom.data

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MutableLiveDataCallback<T>(var liveData: MutableLiveData<T>): Callback<T> {

    override fun onFailure(call: Call<T>, t: Throwable) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        liveData.value = response.body()
    }

}