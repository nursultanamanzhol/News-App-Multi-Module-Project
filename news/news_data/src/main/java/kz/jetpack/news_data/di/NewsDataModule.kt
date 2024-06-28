package kz.jetpack.news_data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.jetpack.news_data.network.NewsApiService
import kz.jetpack.news_data.repository.NewsRepositoryImpl
import kz.jetpack.news_domain.repository.NewsRepository
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module()
object NewsDataModule {

    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }

    @Provides
    fun provideNewsRepository(newsApiService: NewsApiService): NewsRepository {
        return NewsRepositoryImpl(newsApiService)
    }

}