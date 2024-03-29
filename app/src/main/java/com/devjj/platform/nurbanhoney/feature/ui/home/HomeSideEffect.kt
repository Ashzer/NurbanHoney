package com.devjj.platform.nurbanhoney.feature.ui.home

sealed class HomeSideEffect {
    object GetBoards : HomeSideEffect()
    data class GetArticles(val boardName : String) : HomeSideEffect()
    data class ShowToast(val message: String) : HomeSideEffect()
    data class ShowArticleDetail(val board : String, val id : Int) : HomeSideEffect()
}
