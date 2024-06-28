package kz.jetpack.news_presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kz.jetpack.common_utils.Resource
import kz.jetpack.news_domain.use_case.GetNewsArticleUseCase
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsArticleUseCase: GetNewsArticleUseCase) :
    ViewModel() {
    private val _newsArticle = MutableStateFlow(NewsState())
    val newsArticle: StateFlow<NewsState> = _newsArticle

    init {
        getNewsArticles()
    }

    fun getNewsArticles(){
        getNewsArticleUseCase().onEach {

            when (it){
                is Resource.Loading ->{
                    Log.d("LOG_TEMP", "Loading articles")
                    _newsArticle.value = NewsState(isLoading = true)
                }
                is Resource.Error ->{
                    Log.d("LOG_TEMP", "Error loading articles: ${it.message}")
                    _newsArticle.value = NewsState(error = it.message)
                }
                is Resource.Success ->{
                    Log.d("LOG_TEMP", "Articles loaded successfully")
                    _newsArticle.value = NewsState(data = it.data)
                }
            }

        }.launchIn(viewModelScope)
    }
}