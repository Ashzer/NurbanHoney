package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.LocalDateTimeUtils
import com.devjj.platform.nurbanhoney.domain.profile.model.ProfileArticle
import com.devjj.platform.nurbanhoney.extension.empty
import com.google.gson.annotations.SerializedName

data class ProfileArticleEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("board") val board: BoardEntity,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("title") val title: String,
    @SerializedName("commentCount") val commentCount: Int,
    @SerializedName("createdAt") val createAt: String?
) {
    companion object {
        val empty = ProfileArticleEntity(
            0,
            BoardEntity.empty,
            String.empty(),
            String.empty(),
            0,
            null
        )
    }

    fun toProfileArticle() = ProfileArticle(
        id,
        board.toBoardEntity(),
        thumbnail,
        title,
        commentCount,
        if (createAt.isNullOrEmpty()) null else LocalDateTimeUtils.parse(createAt)
    )
}
