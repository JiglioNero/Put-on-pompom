package jiglionero.android.app.putonpompom.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.view.BindingAdapter

class MainWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = MainWeatherFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        DataBindingUtil.setDefaultComponent(BindingAdapter)
        return inflater.inflate(R.layout.main_weather_fragment, container, false)
    }

}
