package com.devjj.platform.nurbanhoney.domain

import okhttp3.MultipartBody
import com.devjj.platform.nurbanhoney.domain.article.model.ArticleEntity
import com.devjj.platform.nurbanhoney.domain.textedit.model.ArticleResponseEntity
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageResponseEntity
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageUploadResultEntity

interface TextEditorRepository {
    fun uploadNurbanArticle(
        board: String,
        token: String,
        title: String,
        uuid: String,
        lossCut: Long,
        thumbnail: String?,
        content: String
    ): Result<ArticleResponseEntity>

    fun uploadArticle(
        board: String,
        token: String,
        title: String,
        uuid: String,
        thumbnail: String?,
        content: String
    ): Result<ArticleResponseEntity>

    fun modifyNurbanArticle(
        board: String,
        token: String,
        articleId: Int,
        thumbnail: String?,
        title: String,
        lossCut: Long,
        content: String
    ): Result<ArticleResponseEntity>

    fun modifyArticle(
        board: String,
        token: String,
        articleId: Int,
        thumbnail: String?,
        title: String,
        content: String
    ): Result<ArticleResponseEntity>

    fun deleteArticle(
        board: String,
        token: String,
        articleId: Int,
        uuid: String
    ): Result<ArticleResponseEntity>

    fun uploadImage(
        board: String,
        token: String,
        uuid: MultipartBody.Part,
        image: MultipartBody.Part
    ): Result<ImageUploadResultEntity>

    fun deleteImages(board: String, token: String, uuid: String): Result<ImageResponseEntity>
}
