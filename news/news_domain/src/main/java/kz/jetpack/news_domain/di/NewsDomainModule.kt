package kz.jetpack.news_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.jetpack.news_domain.repository.NewsRepository
import kz.jetpack.news_domain.use_case.GetNewsArticleUseCase

@InstallIn(SingletonComponent::class)
@Module()
object NewsDomainModule {

    @Provides
    fun provideGetNewsUseCase(newsRepository: NewsRepository): GetNewsArticleUseCase {
        return GetNewsArticleUseCase(newsRepository)
    }

}