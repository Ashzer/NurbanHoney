package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.profile.EditProfileResponseEntity
import com.devjj.platform.nurbanhoney.domain.profile.SignOutResponseEntity
import com.google.gson.annotations.SerializedName
import org.devjj.platform.nurbanhoney.features.ui.article.model.CommentResponseEntity
import org.devjj.platform.nurbanhoney.features.ui.article.model.RatingResponseEntity
import org.devjj.platform.nurbanhoney.features.ui.textedit.ArticleResponseEntity
import org.devjj.platform.nurbanhoney.features.ui.textedit.ImageResponseEntity

data class SimpleNetworkResponse(
    @SerializedName("result") val result : String
){
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