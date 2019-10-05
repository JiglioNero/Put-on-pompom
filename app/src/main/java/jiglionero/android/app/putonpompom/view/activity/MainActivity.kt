package jiglionero.android.app.putonpompom.view.activity

import android.content.pm.PackageManager
import android.os.Bundle
import jiglionero.android.app.putonpompom.PomPomApplication
import jiglionero.android.app.putonpompom.R
import jiglionero.android.app.putonpompom.data.DataNode
import javax.inject.Inject

class MainActivity : PrototypeActivity() {
    //lateinit var navController: NavController
    @Inject lateinit var dataNode: DataNode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PomPomApplication.instance.weatherComponent.inject(this)
        //var navController = Navigation.findNavController(this, R.id.main_nav)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        grantResults.forEach {
            if(it == PackageManager.PERMISSION_DENIED){
                return
            }
        }

        dataNode.isUpdateObservable.set(true)
    }
}
