package kz.jetpack.news_domain.repository

import kz.jetpack.news_domain.model.Article

interface NewsRepository {

    suspend fun getNewsArticle(): List<Article>
}