package jiglionero.android.app.putonpompom.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.data.DataNode
import jiglionero.android.app.putonpompom.databinding.CurrentFragmentBinding
import jiglionero.android.app.putonpompom.model.WeatherCurrentViewModel
import javax.inject.Inject


class CurrentFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    lateinit var binding: CurrentFragmentBinding
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    @Inject
    lateinit var dataNode: DataNode

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
        PomPomApplication.instance.weatherComponent.inject(this)

        viewModel = ViewModelProviders.of(this).get(WeatherCurrentViewModel::class.java)
        //Use the ViewModel
        viewModel.initObserveResponse(this)
        binding.weatherCurrentViewModel = viewModel

        swipeRefreshLayout = binding.swipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener(this)
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark)

        dataNode.isUpdateObservable.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                swipeRefreshLayout.isRefreshing = dataNode.isUpdateObservable.get()
            }
        })

        dataNode.tryToStartUpdate()
    }

    override fun onRefresh() {
        dataNode.tryToStartUpdate()
    }
}
