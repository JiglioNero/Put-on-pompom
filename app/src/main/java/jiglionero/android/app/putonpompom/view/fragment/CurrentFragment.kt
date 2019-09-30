package jiglionero.android.app.putonpompom.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.databinding.CurrentFragmentBinding
import jiglionero.android.app.putonpompom.model.WeatherCurrentViewModel


class CurrentFragment : Fragment() {
    lateinit var binding: CurrentFragmentBinding

    companion object {
        fun newInstance() = CurrentFragment()
    }

    private lateinit var viewModel: WeatherCurrentViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.current_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WeatherCurrentViewModel::class.java)
        //Use the ViewModel
        viewModel.initObserveResponse(this)
        binding.weatherCurrentViewModel = viewModel
    }

}
