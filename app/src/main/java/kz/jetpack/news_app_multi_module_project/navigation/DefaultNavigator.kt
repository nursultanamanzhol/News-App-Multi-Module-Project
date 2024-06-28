package kz.jetpack.news_app_multi_module_project.navigation

import kz.jetpack.common_utils.Activities
import kz.jetpack.common_utils.Navigator
import kz.jetpack.news_presentation.GoToNewsActivity

class DefaultNavigator : Navigator.Provider {
    override fun getActivities(activities: Activities): Navigator {
        return when (activities) {
            Activities.NewsActivity -> {
                GoToNewsActivity
            }

            Activities.SearchActivity -> {
                GoToNewsActivity
            }
        }
    }

}