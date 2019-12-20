package jiglionero.android.app.putonpompom.view

import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingComponent
import com.squareup.picasso.Picasso
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R

object BindingAdapter: DataBindingComponent {

    val BASE_URL = PomPomApplication.instance.getString(
        R.string.base_weather_url
    )+"img/wn/"

    override fun getBindingAdapter(): jiglionero.android.app.putonpompom.view.BindingAdapter {
        return this
    }

    @BindingAdapter(value = ["app:WeatherIconId", "app:WeatherIconSize"], requireAll = true)
    fun loadImage(view: ImageView, iconId: String?, size: Int?) {
        if(iconId!=null && !iconId.isBlank() && size!=null && size > 0) {
            val sizeStr = if (size == 1){
                ""
            }
            else{
                "@$size" + "x"
            }
            val uri = Uri.parse("${BASE_URL}$iconId$sizeStr.png")
            Log.i("Picasso", "Load file: " + "${BASE_URL}$iconId$sizeStr.png")
            //Picasso.get().isLoggingEnabled = true
            Picasso.get().load(uri).into(view)
        }
    }
}