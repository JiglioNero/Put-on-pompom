package jiglionero.android.app.putonpompom.view.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.model.WeatherPerHourForecastViewModel


class ForecastPerHourFragment : Fragment() {

    companion object {
        fun newInstance() =
            ForecastPerHourFragment()
    }

    private lateinit var viewModel: WeatherPerHourForecastViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.forecast_per_hour_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WeatherPerHourForecastViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
