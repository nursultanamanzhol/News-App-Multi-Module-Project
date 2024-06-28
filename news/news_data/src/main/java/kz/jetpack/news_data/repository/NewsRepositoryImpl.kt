package kz.jetpack.news_data.repository

import kz.jetpack.news_data.mapper.toDomainArticle
import kz.jetpack.news_data.network.NewsApiService
import kz.jetpack.news_domain.model.Article
import kz.jetpack.news_domain.repository.NewsRepository

import android.util.Log

class NewsRepositoryImpl(private val newsApiService: NewsApiService) : NewsRepository {
    override suspend fun getNewsArticle(): List<Article> {
        val response = newsApiService.getNewsArticles(country = "us")
        Log.d("LOG_TEMP_IMPL", "Fetched articles: ${response.articles.size}")
        return response.articles.map { it.toDomainArticle() }
    }
}
