package jiglionero.android.app.putonpompom

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class MainWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = MainWeatherFragment()
    }

    private lateinit var viewModel: MainWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainWeatherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
