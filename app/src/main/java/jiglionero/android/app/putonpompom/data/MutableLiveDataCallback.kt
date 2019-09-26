package jiglionero.android.app.putonpompom.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MutableLiveDataCallback<T>(var liveData: MutableLiveData<T>, var ob: T): Callback<T> {

    override fun onFailure(call: Call<T>, t: Throwable) {
        Log.e("Callback", ""+ t.message)
        liveData.value = ob
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if(response.body()!=null) {
            liveData.value = response.body()
        }
        else{
            liveData.value = ob
            when(response.code()){
                503 -> Log.e("Callback", "End of messages count.")
            }
        }
    }

}