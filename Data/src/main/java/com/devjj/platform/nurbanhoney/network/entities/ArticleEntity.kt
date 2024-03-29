package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.article.model.Article
import com.google.gson.annotations.SerializedName

data class ArticleEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("uuid") val uuid: String?,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("lossCut") val lossCut: Int?,
    @SerializedName("content") val content: String?,
    @SerializedName("count") val inquiries: Int,
    @SerializedName("commentCount") val comments: Int?,
    @SerializedName("likeCount") val likes: Int,
    @SerializedName("dislikeCount") val dislikes: Int,
    @SerializedName("updatedAt") val date: String?,
    @SerializedName("userId") val userId: Int?,
    @SerializedName("badge") val badge: String?,
    @SerializedName("nickname") val nickname: String?,
    @SerializedName("insignia") val insignia: List<String>?,
    @SerializedName("myRating") val myRating: String?
) {

    fun toArticle() =
        Article(
            id,
            uuid ?: "",
            thumbnail ?: "",
            title ?: "",
            lossCut ?: -1,
            content ?: "",
            inquiries,
            comments ?: 0,
            likes,
            dislikes,
            date ?: "",
            userId ?: -1,
            badge ?: "",
            nickname ?: "who?",
            insignia ?: listOf(),
            myRating ?: ""
        )

    companion object {
        val empty = ArticleEntity(-1, "", "", "", 0, "", 0, 0, 0, 0, "", 0, "", "", listOf(), "")
    }
}
