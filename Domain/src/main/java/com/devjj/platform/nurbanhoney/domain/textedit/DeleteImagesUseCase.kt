package com.devjj.platform.nurbanhoney.domain.textedit

import com.devjj.platform.nurbanhoney.domain.TextEditorRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageResponseEntity
import javax.inject.Inject

class DeleteImagesUseCase
@Inject constructor(
    private val repository: TextEditorRepository
) : UseCase<ImageResponseEntity, DeleteImagesUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.deleteImages(params.board, params.token, params.uuid)

    data class Params(
        val board: String,
        val token: String,
        val uuid: String,
    )
}