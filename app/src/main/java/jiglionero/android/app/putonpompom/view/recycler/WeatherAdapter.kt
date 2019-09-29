package jiglionero.android.app.putonpompom.view.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import jiglionero.android.app.putonpompom.databinding.WeatherPerHourElBinding
import jiglionero.android.app.putonpompom.domain.OneWeather

class WeatherAdapter(diffUtilCallback: DiffUtil.ItemCallback<OneWeather>) : PagedListAdapter<OneWeather, WeatherAdapter.OneWeatherHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneWeatherHolder {
        val binding = DataBindingUtil.inflate<WeatherPerHourElBinding>(
            LayoutInflater.from(parent.context),
            jiglionero.android.app.putonpompom.R.layout.weather_per_hour_el,
            parent,
            false)
        return OneWeatherHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: OneWeatherHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class OneWeatherHolder(itemView: View, val binding: WeatherPerHourElBinding) : RecyclerView.ViewHolder(itemView) {

        fun bind(oneWeather: OneWeather?) {
            if (oneWeather!=null) {
                binding.oneWeather = oneWeather
            }
        }
    }

}