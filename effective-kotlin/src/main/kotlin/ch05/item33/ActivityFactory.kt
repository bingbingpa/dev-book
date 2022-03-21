package ch05.item33

class Context {
    fun startActivity(intent: Intent) {}
}
class Intent
class Activity {
    fun startActivityForResult(activity: Activity, requestCode: Int) {}
}

abstract class ActivityFactory {
    abstract fun getIntent(context: Context): Intent

    fun start(context: Context) {
        val intent = getIntent(context)
        context.startActivity(intent)
    }

    fun startForResult(activity: Activity, requestCode: Int) {
//        val intent = getIntent(activity)
//        activity.startActivityForResult(intent, requestCode)
    }
}

open class AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object : ActivityFactory() {
        override fun getIntent(context: Context): Intent {
            return Intent()
        }
    }
}