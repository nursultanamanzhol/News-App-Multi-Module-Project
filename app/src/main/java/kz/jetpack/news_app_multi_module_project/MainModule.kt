package kz.jetpack.news_app_multi_module_project

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kz.jetpack.common_utils.Navigator
import kz.jetpack.news_app_multi_module_project.navigation.DefaultNavigator
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MainModule {


    @Provides
    @Singleton
    fun provideProvider(): Navigator.Provider {
        return DefaultNavigator()
    }
}