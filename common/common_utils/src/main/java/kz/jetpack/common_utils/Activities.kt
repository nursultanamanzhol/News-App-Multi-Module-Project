package kz.jetpack.common_utils

sealed class Activities {
    object NewsActivity : Activities()
    object SearchActivity : Activities()
}