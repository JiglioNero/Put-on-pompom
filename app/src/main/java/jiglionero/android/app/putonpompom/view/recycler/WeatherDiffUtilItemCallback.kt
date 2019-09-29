package jiglionero.android.app.putonpompom.view.recycler

import androidx.recyclerview.widget.DiffUtil
import jiglionero.android.app.putonpompom.domain.OneWeather

class WeatherDiffUtilItemCallback : DiffUtil.ItemCallback<OneWeather>() {
    override fun areItemsTheSame(oldItem: OneWeather, newItem: OneWeather): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: OneWeather, newItem: OneWeather): Boolean {
        return oldItem == newItem
    }
}