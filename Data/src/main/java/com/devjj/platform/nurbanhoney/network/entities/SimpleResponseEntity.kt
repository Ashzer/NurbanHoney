package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.article.model.CommentResponse
import com.devjj.platform.nurbanhoney.domain.article.model.RatingResponse
import com.devjj.platform.nurbanhoney.domain.profile.model.EditProfileResponse
import com.devjj.platform.nurbanhoney.domain.profile.model.SignOutResponse
import com.devjj.platform.nurbanhoney.domain.textedit.model.ArticleResponse
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageResponse
import com.google.gson.annotations.SerializedName

data class SimpleResponseEntity(
    @SerializedName("result") val result: String
) {
    fun toCommentResponse() = CommentResponse(result)
    fun toRatingResponse() = RatingResponse(result)
    fun toArticleResponse() = ArticleResponse(result)
    fun toImageResponse() = ImageResponse(result)
    fun toEditProfileResponse() = EditProfileResponse(result)
    fun toSignOutResponse() = SignOutResponse(result)
    companion object {
        val empty = SimpleResponseEntity("")
    }
}
