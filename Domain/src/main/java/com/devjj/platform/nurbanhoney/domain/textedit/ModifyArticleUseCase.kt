package com.devjj.platform.nurbanhoney.domain.textedit

import com.devjj.platform.nurbanhoney.domain.TextEditorRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.textedit.model.ArticleResponse
import javax.inject.Inject

class ModifyArticleUseCase
@Inject constructor(
    private val repository: TextEditorRepository
) : UseCase<ArticleResponse, ModifyArticleUseCase.Params>() {
    override suspend fun run(params: Params) = repository.modifyArticle(
        params.board,
        params.token,
        params.articleId,
        params.thumbnail,
        params.title,
        params.content
    )

    data class Params(
        val board: String,
        val token: String,
        val articleId: Int,
        val thumbnail: String?,
        val title: String,
        val content: String
    )
}
