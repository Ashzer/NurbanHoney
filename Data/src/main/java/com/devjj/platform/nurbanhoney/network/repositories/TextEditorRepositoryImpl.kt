package com.devjj.platform.nurbanhoney.network.repositories

import com.devjj.platform.nurbanhoney.domain.TextEditorRepository
import com.devjj.platform.nurbanhoney.domain.textedit.model.ArticleResponse
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageResponse
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageUploadResult
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import com.devjj.platform.nurbanhoney.network.NetworkHandler
import com.devjj.platform.nurbanhoney.network.entities.SimpleResponseEntity
import com.devjj.platform.nurbanhoney.network.entities.UploadedImageEntity
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
    ): Result<ArticleResponse> {
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
                SimpleResponseEntity.empty
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
    ): Result<ArticleResponse> {
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
                SimpleResponseEntity.empty
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
    ): Result<ArticleResponse> {
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
                SimpleResponseEntity.empty
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
    ): Result<ArticleResponse> {
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
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun deleteArticle(
        board: String,
        token: String,
        articleId: Int,
        uuid: String
    ): Result<ArticleResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                boardService.deleteArticle(
                    board,
                    token,
                    articleId,
                    uuid
                ),
                { it.toArticleResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun uploadImage(
        board: String,
        token: String,
        uuid: MultipartBody.Part,
        image: MultipartBody.Part
    ): Result<ImageUploadResult> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                boardService.uploadImage(
                    board,
                    token,
                    uuid,
                    image
                ),
                { it.toImageUploadResult() },
                UploadedImageEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun deleteImages(
        board: String,
        token: String,
        uuid: String
    ): Result<ImageResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                boardService.deleteImage(
                    board,
                    token,
                    uuid
                ),
                { it.toImageResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }
}
