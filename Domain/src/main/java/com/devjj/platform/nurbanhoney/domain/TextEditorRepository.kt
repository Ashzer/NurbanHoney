package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.textedit.model.ArticleResponse
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageResponse
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageUploadResult
import okhttp3.MultipartBody

interface TextEditorRepository {
	fun uploadNurbanArticle(
		board: String,
		token: String,
		title: String,
		uuid: String,
		lossCut: Long,
		thumbnail: String?,
		content: String
	): Result<ArticleResponse>

	fun uploadArticle(
		board: String,
		token: String,
		title: String,
		uuid: String,
		thumbnail: String?,
		content: String
	): Result<ArticleResponse>

	fun modifyNurbanArticle(
		board: String,
		token: String,
		articleId: Int,
		thumbnail: String?,
		title: String,
		lossCut: Long,
		content: String
	): Result<ArticleResponse>

	fun modifyArticle(
		board: String,
		token: String,
		articleId: Int,
		thumbnail: String?,
		title: String,
		content: String
	): Result<ArticleResponse>

	fun deleteArticle(
		board: String,
		token: String,
		articleId: Int,
		uuid: String
	): Result<ArticleResponse>

	fun uploadImage(
		board: String,
		token: String,
		uuid: MultipartBody.Part,
		image: MultipartBody.Part
	): Result<ImageUploadResult>

	fun deleteImages(
		board: String,
		token: String,
		uuid: String
	): Result<ImageResponse>
}
