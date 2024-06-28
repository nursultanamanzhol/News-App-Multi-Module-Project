package kz.jetpack.news_data.mapper

import kz.jetpack.news_data.model.ArticleDTO
import kz.jetpack.news_domain.model.Article

fun ArticleDTO.toDomainArticle(): Article {
    return Article(
        author = this.author,
        content = this.content,
        description = this.description,
        title = this.title,
        urlToImage = this.urlToImage
    )
}