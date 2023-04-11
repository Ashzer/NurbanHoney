package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.article.model.CommentResponseEntity
import com.devjj.platform.nurbanhoney.domain.article.model.RatingResponseEntity
import com.devjj.platform.nurbanhoney.domain.profile.model.EditProfileResponseEntity
import com.devjj.platform.nurbanhoney.domain.profile.model.SignOutResponseEntity
import com.devjj.platform.nurbanhoney.domain.textedit.model.ArticleResponseEntity
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageResponseEntity
import com.google.gson.annotations.SerializedName

data class SimpleNetworkResponse(
    @SerializedName("result") val result: String
) {
    fun toCommentResponse() = CommentResponseEntity(result)
    fun toRatingResponse() = RatingResponseEntity(result)
    fun toArticleResponse() = ArticleResponseEntity(result)
    fun toImageResponse() = ImageResponseEntity(result)
    fun toEditProfileResponse() = EditProfileResponseEntity(result)
    fun toSignOutResponse() = SignOutResponseEntity(result)
    companion object {
        val empty = SimpleNetworkResponse("")
    }
}
