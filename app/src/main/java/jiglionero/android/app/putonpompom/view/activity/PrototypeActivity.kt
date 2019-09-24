package jiglionero.android.app.putonpompom.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import jiglionero.android.app.putonpompom.PomPomApplication

abstract class PrototypeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PomPomApplication.instance.currentActivity = this
        actionBar?.setDisplayShowTitleEnabled(false)
    }
}