package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.LocalDateTimeUtils
import com.devjj.platform.nurbanhoney.domain.profile.model.ProfileCommentEntity
import com.devjj.platform.nurbanhoney.extension.empty
import com.google.gson.annotations.SerializedName

data class ProfileCommentNetworkResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("board") val board: BoardNetworkResponse,
    @SerializedName("content") val content: String,
    @SerializedName("createdAt") val createAt: String?,
    @SerializedName("Location") val articleInfo: ArticleInfo
) {
    data class ArticleInfo(
        @SerializedName("articleId") val articleId: Int,
        @SerializedName("title") val title: String
    )

    companion object {
        val empty = ProfileCommentNetworkResponse(
            -1,
            BoardNetworkResponse.empty,
            String.empty(),
            null,
            ArticleInfo(-1, String.empty())
        )
    }

    fun toProfileComment() = ProfileCommentEntity(
        id,
        content,
        articleInfo.articleId,
        if (createAt.isNullOrEmpty()) null else LocalDateTimeUtils.parse(createAt),
        board.toBoardEntity(),
        articleInfo.title
    )
}
