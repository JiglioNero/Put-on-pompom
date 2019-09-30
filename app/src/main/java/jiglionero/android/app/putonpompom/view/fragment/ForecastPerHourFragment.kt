package jiglionero.android.app.putonpompom.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
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

        viewModel.initObserveResponse(this)
        view?.findViewById<RecyclerView>(R.id.per_hour_list)?.adapter = viewModel.weatherAdapter
    }

}
