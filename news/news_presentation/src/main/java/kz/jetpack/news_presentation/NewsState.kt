package kz.jetpack.news_presentation

import kz.jetpack.news_domain.model.Article

data class NewsState(
    val isLoading:Boolean = false,
    val error: String = "",
    val data:List<Article>? = null
)
