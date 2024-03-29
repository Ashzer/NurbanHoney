package com.devjj.platform.nurbanhoney.domain.article.model

import com.devjj.platform.nurbanhoney.extension.empty

data class Ratings(
    val likes: Int,
    val dislikes: Int,
    val myRating: String
) {
    companion object {
        val empty = Ratings(0, 0, String.empty())

        enum class MyRating(
            val LIKE: String = "like",
            val DISLIKE: String = "dislike",
            val NONE: String? = null
        )
    }
}
