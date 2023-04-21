package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.extension.LocalDateTimeUtils
import com.devjj.platform.nurbanhoney.domain.profile.model.ProfileComment
import com.devjj.platform.nurbanhoney.extension.empty
import com.google.gson.annotations.SerializedName

data class ProfileCommentEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("board") val board: BoardEntity,
    @SerializedName("content") val content: String,
    @SerializedName("createdAt") val createAt: String?,
    @SerializedName("Location") val articleInfo: ArticleInfo
) {
    data class ArticleInfo(
        @SerializedName("articleId") val articleId: Int,
        @SerializedName("title") val title: String
    )

    companion object {
        val empty = ProfileCommentEntity(
            -1,
            BoardEntity.empty,
            String.empty(),
            null,
            ArticleInfo(-1, String.empty())
        )
    }

    fun toProfileComment() = ProfileComment(
        id,
        content,
        articleInfo.articleId,
        if (createAt.isNullOrEmpty()) null else LocalDateTimeUtils.parse(createAt),
        board.toBoardEntity(),
        articleInfo.title
    )
}
