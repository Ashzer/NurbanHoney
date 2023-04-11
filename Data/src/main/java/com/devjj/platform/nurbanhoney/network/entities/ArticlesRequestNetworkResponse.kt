package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.article.model.ArticleItemEntity
import com.devjj.platform.nurbanhoney.domain.board.model.BoardEntity
import com.google.gson.annotations.SerializedName

data class ArticlesRequestNetworkResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("title") val title: String,
    @SerializedName("count") val count: Int?,
    @SerializedName("commentCount") val commentCount: Int,
    @SerializedName("board") val board: BoardNetworkResponse?,
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

    fun toNurbanHoneyArticle() = ArticleItemEntity(
        id,
        thumbnail ?: "",
        title,
        commentCount,
        board?.toBoardEntity() ?: BoardEntity.empty,
        user?.profile ?: "",
        user?.nickname ?: "Empty Nickname",
        likeCount,
        createdAt
        // user?.insignia ?: "No insignia"
    )
}
