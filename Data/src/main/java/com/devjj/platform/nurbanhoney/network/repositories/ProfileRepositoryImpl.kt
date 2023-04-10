package com.devjj.platform.nurbanhoney.network.repositories

import com.devjj.platform.nurbanhoney.domain.ProfileRepository
import com.devjj.platform.nurbanhoney.domain.profile.model.*
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import com.devjj.platform.nurbanhoney.network.NetworkHandler
import com.devjj.platform.nurbanhoney.network.entities.ProfileNetworkResponse
import com.devjj.platform.nurbanhoney.network.entities.SimpleNetworkResponse
import com.devjj.platform.nurbanhoney.network.request
import com.devjj.platform.nurbanhoney.network.service.ProfileService
import javax.inject.Inject

class ProfileRepositoryImpl
@Inject constructor(
    private val networkHandler: NetworkHandler,
    private val profileService: ProfileService
) : ProfileRepository {
    override fun getProfile(token: String): Result<ProfileEntity> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                profileService.getProfile(token),
                { it.toProfile() },
                ProfileNetworkResponse.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun getMyArticles(
        token: String,
        offset: Int,
        limit: Int
    ): Result<List<ProfileArticleEntity>> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                profileService.getMyArticles(
                    token,
                    offset,
                    limit
                ),
                { it.map { ProfileArticleEntity -> ProfileArticleEntity.toProfileArticle() } },
                listOf()
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun getMyComments(
        token: String,
        offset: Int,
        limit: Int
    ): Result<List<ProfileCommentEntity>> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                profileService.getMyComments(
                    token,
                    offset,
                    limit
                ),
                { it.map { ProfileCommentEntity -> ProfileCommentEntity.toProfileComment() } },
                listOf()
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun signOut(
        token: String,
        id: Int
    ): Result<SignOutResponseEntity> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                profileService.signOut(token, id),
                { it.toSignOutResponse() },
                SimpleNetworkResponse.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun editProfile(
        token: String,
        nickname: String,
        description: String,
        insignia: List<String>
    ): Result<EditProfileResponseEntity> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                profileService.editProfile(
                    token,
                    nickname,
                    description,
                    insignia
                ),
                { it.toEditProfileResponse() },
                SimpleNetworkResponse.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }
}
