package com.devjj.platform.nurbanhoney.domain.textedit

import com.devjj.platform.nurbanhoney.domain.TextEditorRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.textedit.model.ArticleResponse
import javax.inject.Inject

class UploadNurbanArticleUseCase
@Inject constructor(
    private val repository: TextEditorRepository
) : UseCase<ArticleResponse, UploadNurbanArticleUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.uploadNurbanArticle(
            params.board,
            params.token,
            params.title,
            params.uuid,
            params.lossCut,
            params.thumbnail,
            params.content
        )

    data class Params(
        val board: String,
        val token: String,
        val title: String,
        val uuid: String,
        val lossCut: Long,
        val thumbnail: String?,
        val content: String
    )
} // token,title, uuid , lossCut , thumbnail  ,content
