package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.article.model.Comment
import com.devjj.platform.nurbanhoney.extension.empty
import com.google.gson.annotations.SerializedName

class CommentEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("content") val comment: String,
    @SerializedName("articleId") val articleId: Int,
    @SerializedName("user") val user: User
) {
    data class User(
        @SerializedName("userId") val userId: Int,
        @SerializedName("badge") val badge: String,
        @SerializedName("nickname") val nickname: String,
        @SerializedName("insignia") val insignia: List<String>?
    )

    fun toComment() =
        Comment(id, comment, articleId, user.userId, user.badge, user.nickname, user.insignia ?: listOf())

    companion object {
        val empty = CommentEntity(
            0,
            String.empty(),
            0,
            User(0, String.empty(), String.empty(), listOf())
        )
    }
}
