package com.devjj.platform.nurbanhoney.domain.textedit

import com.devjj.platform.nurbanhoney.domain.TextEditorRepository
import com.devjj.platform.nurbanhoney.domain.article.model.ArticleEntity
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.textedit.model.ArticleResponseEntity
import javax.inject.Inject

class DeleteArticleUseCase
@Inject constructor(
    private val repository: TextEditorRepository
) : UseCase<ArticleResponseEntity, DeleteArticleUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.deleteArticle(params.board,params.token, params.articleId, params.uuid)

    data class Params(
        val board: String,
        val token: String,
        val articleId: Int,
        val uuid: String,
    )
}