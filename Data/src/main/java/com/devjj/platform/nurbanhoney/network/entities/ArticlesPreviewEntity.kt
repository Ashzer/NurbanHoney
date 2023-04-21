package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.extension.LocalDateTimeUtils
import com.devjj.platform.nurbanhoney.domain.article.model.ArticlePreview
import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.google.gson.annotations.SerializedName
import org.threeten.bp.LocalDateTime

data class ArticlesPreviewEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("title") val title: String,
    @SerializedName("count") val count: Int?,
    @SerializedName("commentCount") val commentCount: Int,
    @SerializedName("board") val board: BoardEntity?,
    @SerializedName("user") val user: User?,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("likeCount") val likeCount: Int
) {
    data class User(
        @SerializedName("userId") val userId: Int,
        @SerializedName("badge") val profile: String,
        @SerializedName("nickname") val nickname: String
        // @SerializedName("insignia") val insignia: String?
        // @SerializedName("insignia") val insignia : List<String>
    )

    fun toNurbanHoneyArticle() = ArticlePreview(
        id,
        thumbnail ?: "",
        title,
        commentCount,
        board?.toBoardEntity() ?: Board.empty,
        user?.profile ?: "",
        user?.nickname ?: "Empty Nickname",
        likeCount,
        if (createdAt.isEmpty()) LocalDateTime.now() else LocalDateTimeUtils.parse(createdAt),
        // user?.insignia ?: "No insignia"
    )
}
