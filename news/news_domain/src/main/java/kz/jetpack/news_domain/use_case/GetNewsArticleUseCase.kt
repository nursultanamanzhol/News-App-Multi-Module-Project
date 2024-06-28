package kz.jetpack.news_domain.use_case

import kotlinx.coroutines.flow.flow
import kz.jetpack.common_utils.Resource
import kz.jetpack.news_domain.model.Article
import kz.jetpack.news_domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import java.io.IOException


class GetNewsArticleUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = newsRepository.getNewsArticle()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}