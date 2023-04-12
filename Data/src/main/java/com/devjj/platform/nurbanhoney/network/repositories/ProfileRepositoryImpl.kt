package com.devjj.platform.nurbanhoney.network.repositories

import com.devjj.platform.nurbanhoney.domain.ProfileRepository
import com.devjj.platform.nurbanhoney.domain.profile.model.*
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import com.devjj.platform.nurbanhoney.network.NetworkHandler
import com.devjj.platform.nurbanhoney.network.entities.ProfileEntity
import com.devjj.platform.nurbanhoney.network.entities.SimpleResponseEntity
import com.devjj.platform.nurbanhoney.network.request
import com.devjj.platform.nurbanhoney.network.service.ProfileService
import javax.inject.Inject

class ProfileRepositoryImpl
@Inject constructor(
    private val networkHandler: NetworkHandler,
    private val profileService: ProfileService
) : ProfileRepository {
    override fun getProfile(token: String): Result<Profile> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                profileService.getProfile(token),
                { it.toProfile() },
                ProfileEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun getMyArticles(
        token: String,
        offset: Int,
        limit: Int
    ): Result<List<ProfileArticle>> {
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
    ): Result<List<ProfileComment>> {
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
    ): Result<SignOutResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                profileService.signOut(token, id),
                { it.toSignOutResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun editProfile(
        token: String,
        nickname: String,
        description: String,
        insignia: List<String>
    ): Result<EditProfileResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                profileService.editProfile(
                    token,
                    nickname,
                    description,
                    insignia
                ),
                { it.toEditProfileResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }
}
