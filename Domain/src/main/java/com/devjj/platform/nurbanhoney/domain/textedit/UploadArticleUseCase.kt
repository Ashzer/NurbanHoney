package com.devjj.platform.nurbanhoney.domain.textedit

import com.devjj.platform.nurbanhoney.domain.TextEditorRepository
import com.devjj.platform.nurbanhoney.domain.article.model.ArticleEntity
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class UploadArticleUseCase
@Inject constructor(
    private val repository: TextEditorRepository
) : UseCase<ArticleEntity, UploadArticleUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.uploadArticle(
            params.board,
            params.token,
            params.title,
            params.uuid,
            params.thumbnail,
            params.content
        )

    data class Params(
        val board: String,
        val token: String,
        val title: String,
        val uuid: String,
        val thumbnail: String?,
        val content: String,
    )
}