package jiglionero.android.app.putonpompom.view.activity

import android.os.Bundle
import jiglionero.android.app.putonpompom.R

class MainActivity : PrototypeActivity() {
    //lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var navController = Navigation.findNavController(this, R.id.main_nav)
    }
}
