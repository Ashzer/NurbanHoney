package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.LocalDateTimeUtils
import com.devjj.platform.nurbanhoney.domain.profile.ProfileArticleEntity
import com.devjj.platform.nurbanhoney.extension.empty
import com.google.gson.annotations.SerializedName

data class ProfileArticleNetworkResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("board") val board: BoardNetworkResponse,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("title") val title: String,
    @SerializedName("commentCount") val commentCount: Int,
    @SerializedName("createdAt") val createAt: String?
) {
    companion object {
        val empty = ProfileArticleNetworkResponse(
            0,
            BoardNetworkResponse.empty,
            String.empty(),
            String.empty(),
            0,
            null
        )
    }

    fun toProfileArticle() = ProfileArticleEntity(
        id,
        board.toBoardEntity(),
        thumbnail,
        title,
        commentCount,
        if(createAt.isNullOrEmpty()) null else LocalDateTimeUtils.parse(createAt)
    )
}