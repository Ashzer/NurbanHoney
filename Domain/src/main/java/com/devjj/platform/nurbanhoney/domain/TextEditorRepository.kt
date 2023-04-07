package com.devjj.platform.nurbanhoney.domain

import okhttp3.MultipartBody
import org.devjj.platform.nurbanhoney.features.ui.article.model.ArticleEntity
import org.devjj.platform.nurbanhoney.features.ui.textedit.ImageResponseEntity
import org.devjj.platform.nurbanhoney.features.ui.textedit.ImageUploadResultEntity

interface TextEditorRepository {
    fun uploadNurbanArticle(
        board: String,
        token: String,
        title: String,
        uuid: String,
        lossCut: Long,
        thumbnail: String?,
        content: String
    ): Result<ArticleEntity>

    fun uploadArticle(
        board: String,
        token: String,
        title: String,
        uuid: String,
        thumbnail: String?,
        content: String
    ): Result<ArticleEntity>

    fun modifyNurbanArticle(
        board: String,
        token: String,
        articleId: Int,
        thumbnail: String?,
        title: String,
        lossCut: Long,
        content: String
    ): Result<ArticleEntity>

    fun modifyArticle(
        board: String,
        token: String,
        articleId: Int,
        thumbnail: String?,
        title: String,
        content: String
    ): Result<ArticleEntity>

    fun deleteArticle(
        board: String,
        token: String,
        articleId: Int,
        uuid: String
    ): Result<ArticleEntity>

    fun uploadImage(
        board: String,
        token: String,
        uuid: MultipartBody.Part,
        image: MultipartBody.Part
    ): Result<ImageUploadResultEntity>

    fun deleteImages(board: String, token: String, uuid: String): Result<ImageResponseEntity>

}