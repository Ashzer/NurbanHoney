package com.devjj.platform.nurbanhoney.network.repositories

import com.devjj.platform.nurbanhoney.domain.TextEditorRepository
import com.devjj.platform.nurbanhoney.domain.textedit.model.ArticleResponseEntity
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageResponseEntity
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageUploadResultEntity
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import com.devjj.platform.nurbanhoney.network.NetworkHandler
import com.devjj.platform.nurbanhoney.network.entities.SimpleNetworkResponse
import com.devjj.platform.nurbanhoney.network.entities.UploadImageNetworkResponse
import com.devjj.platform.nurbanhoney.network.request
import com.devjj.platform.nurbanhoney.network.service.BoardService
import okhttp3.MultipartBody
import javax.inject.Inject

class TextEditorRepositoryImpl
@Inject constructor(
	private val networkHandler: NetworkHandler,
	private val boardService: BoardService
) : TextEditorRepository {
	override fun uploadNurbanArticle(
		board: String,
		token: String,
		title: String,
		uuid: String,
		lossCut: Long,
		thumbnail: String?,
		content: String
	): Result<ArticleResponseEntity> {
		return when (networkHandler.isNetworkAvailable()) {
			true -> request(
				boardService.uploadNurbanRequest(
					board,
					token,
					title,
					uuid,
					lossCut,
					thumbnail,
					content
				),
				{ it.toArticleResponse() },
				SimpleNetworkResponse.empty
			)
			false -> Result.failure(Failure.NetworkFailure)
		}
	}

	override fun uploadArticle(
		board: String,
		token: String,
		title: String,
		uuid: String,
		thumbnail: String?,
		content: String
	): Result<ArticleResponseEntity> {
		return when (networkHandler.isNetworkAvailable()) {
			true -> request(
				boardService.uploadRequest(
					board,
					token,
					title,
					uuid,
					thumbnail,
					content
				),
				{ it.toArticleResponse() },
				SimpleNetworkResponse.empty
			)
			false -> Result.failure(Failure.NetworkFailure)
		}
	}

	override fun modifyNurbanArticle(
		board: String,
		token: String,
		articleId: Int,
		thumbnail: String?,
		title: String,
		lossCut: Long,
		content: String
	): Result<ArticleResponseEntity> {
		return when (networkHandler.isNetworkAvailable()) {
			true -> request(
				boardService.modifyNurbanRequest(
					board,
					token,
					articleId,
					thumbnail,
					title,
					lossCut,
					content
				),
				{ it.toArticleResponse() },
				SimpleNetworkResponse.empty
			)
			false -> Result.failure(Failure.NetworkFailure)
		}
	}

	override fun modifyArticle(
		board: String,
		token: String,
		articleId: Int,
		thumbnail: String?,
		title: String,
		content: String
	): Result<ArticleResponseEntity> {
		return when (networkHandler.isNetworkAvailable()) {
			true -> request(
				boardService.modifyRequest(
					board,
					token,
					articleId,
					thumbnail,
					title,
					content
				),
				{ it.toArticleResponse() },
				SimpleNetworkResponse.empty
			)
			false -> Result.failure(Failure.NetworkFailure)
		}
	}

	override fun deleteArticle(
		board: String,
		token: String,
		articleId: Int,
		uuid: String
	): Result<ArticleResponseEntity> {
		return when (networkHandler.isNetworkAvailable()) {
			true -> request(
				boardService.deleteArticle(
					board, token, articleId, uuid
				),
				{ it.toArticleResponse() },
				SimpleNetworkResponse.empty
			)
			false -> Result.failure(Failure.NetworkFailure)
		}
	}

	override fun uploadImage(
		board: String,
		token: String,
		uuid: MultipartBody.Part,
		image: MultipartBody.Part
	): Result<ImageUploadResultEntity> {
		return when (networkHandler.isNetworkAvailable()) {
			true -> request(
				boardService.uploadImage(
					board, token, uuid, image
				 ),
				{ it.toImageUploadResult() },
				UploadImageNetworkResponse.empty
			)
			false -> Result.failure(Failure.NetworkFailure)
		}
	}

	override fun deleteImages(
		board: String, token: String, uuid: String
	): Result<ImageResponseEntity> {
		return when (networkHandler.isNetworkAvailable()) {
			true -> request(
				boardService.deleteImage(
					board, token, uuid
				),
				{ it.toImageResponse() },
				SimpleNetworkResponse.empty
			)
			false -> Result.failure(Failure.NetworkFailure)
		}
	}
}
