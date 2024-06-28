package kz.jetpack.search_presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.jetpack.common_utils.Navigator

class SearchActivity : AppCompatActivity() {
    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, SearchActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }
}
object GoToNewsActivity : Navigator {
    override fun navigate(activity: Activity) {
        SearchActivity.launchActivity(activity)
    }

}