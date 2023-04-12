package com.devjj.platform.nurbanhoney.domain.textedit

import com.devjj.platform.nurbanhoney.domain.TextEditorRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageUploadResult
import okhttp3.MultipartBody
import javax.inject.Inject

class UploadImageUseCase
@Inject constructor(
    private val repository: TextEditorRepository
) : UseCase<ImageUploadResult, UploadImageUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.uploadImage(params.board, params.token, params.uuid, params.image)

    data class Params(
        val board: String,
        val token: String,
        val uuid: MultipartBody.Part,
        val image: MultipartBody.Part
    )
}
