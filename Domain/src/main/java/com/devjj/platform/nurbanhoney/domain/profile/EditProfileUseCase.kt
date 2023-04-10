package com.devjj.platform.nurbanhoney.domain.profile

import com.devjj.platform.nurbanhoney.domain.ProfileRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.profile.model.EditProfileResponseEntity
import javax.inject.Inject

class EditProfileUseCase
@Inject constructor(
    private val repository: ProfileRepository
) : UseCase<EditProfileResponseEntity, EditProfileUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.editProfile(params.token, params.nickname, params.description, params.insignia)

    data class Params(
        val token: String,
        val nickname: String,
        val description: String,
        val insignia: List<String>
    )
}