package com.devjj.platform.nurbanhoney.domain.textedit

import com.devjj.platform.nurbanhoney.domain.TextEditorRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.textedit.model.ArticleResponse
import javax.inject.Inject

class ModifyNurbanArticleUseCase
@Inject constructor(
    private val repository: TextEditorRepository
) : UseCase<ArticleResponse, ModifyNurbanArticleUseCase.Params>() {
    override suspend fun run(params: Params) = repository.modifyNurbanArticle(
        params.board,
        params.token,
        params.articleId,
        params.thumbnail,
        params.title,
        params.lossCut,
        params.content
    )

    data class Params(
        val board: String,
        val token: String,
        val articleId: Int,
        val thumbnail: String?,
        val title: String,
        val lossCut: Long,
        val content: String
    )
}
