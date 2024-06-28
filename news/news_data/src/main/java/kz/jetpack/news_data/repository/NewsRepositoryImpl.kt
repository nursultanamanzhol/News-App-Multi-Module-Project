package kz.jetpack.news_data.repository

import kz.jetpack.news_data.mapper.toDomainArticle
import kz.jetpack.news_data.network.NewsApiService
import kz.jetpack.news_domain.model.Article
import kz.jetpack.news_domain.repository.NewsRepository

class NewsRepositoryImpl(private val newsApiService: NewsApiService) : NewsRepository {
    override suspend fun getNewsArticle(): List<Article> {
        return newsApiService.getNewsArticles(country = "kz").articles.map { it.toDomainArticle() }


    }
}