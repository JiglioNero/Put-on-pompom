package jiglionero.android.app.putonpompom.view

import android.net.Uri
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
            val uri: Uri = if (size == 1) {
                Uri.parse("${BASE_URL}$iconId.png")
            } else{
                Uri.parse("${BASE_URL}$iconId@$size" + "x.png")
            }
            Picasso.get().load(uri).into(view)
        }
    }
}