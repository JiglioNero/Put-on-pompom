package jiglionero.android.app.putonpompom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import jiglionero.android.app.putonpompom.databinding.MainWeatherFragmentBinding


class MainWeatherFragment : Fragment() {
    lateinit var binding: MainWeatherFragmentBinding

    companion object {
        fun newInstance() = MainWeatherFragment()
    }

    private lateinit var viewModel: MainWeatherViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_weather_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainWeatherViewModel::class.java)
        //Use the ViewModel
        binding.weatherViewModel = viewModel
    }

}
