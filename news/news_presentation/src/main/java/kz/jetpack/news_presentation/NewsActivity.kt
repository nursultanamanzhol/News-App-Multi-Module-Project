package kz.jetpack.news_presentation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kz.jetpack.common_utils.Navigator
import kz.jetpack.news_presentation.databinding.ActivityNewsBinding

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, NewsActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private var _binding: ActivityNewsBinding? = null
    private val binding: ActivityNewsBinding
        get() = _binding!!

    private val newsAdapter = NewsAdapter()

    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setObservers()
        initView()
    }

    private fun initView() {
        binding.recycArticles.adapter = newsAdapter
    }

    private fun setObservers() {
        lifecycleScope.launchWhenCreated {
            newsViewModel.newsArticle.collectLatest {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                    Log.d("LOG_TEMP", "Loading articles")
                }
                if (it.error.isNotBlank()) {
                    binding.progressBar.visibility = View.GONE
                    Log.d("LOG_TEMP", "Error loading articles: ${it.error}")
                    Toast.makeText(this@NewsActivity, it.error, Toast.LENGTH_SHORT).show()
                }
                it.data?.let {
                    binding.progressBar.visibility = View.GONE
                    Log.d("LOG_TEMP", "Articles loaded successfully: ${it.size} articles")
                    newsAdapter.setData(it)
                }
            }
        }

    }

}

object GoToNewsActivity : Navigator {
    override fun navigate(activity: Activity) {
        NewsActivity.launchActivity(activity)
    }

}