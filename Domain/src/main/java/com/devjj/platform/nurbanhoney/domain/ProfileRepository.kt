package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.profile.model.*

interface ProfileRepository {
    fun getProfile(token: String): Result<ProfileEntity>
    fun getMyArticles(
        token: String,
        offset: Int,
        limit: Int
    ): Result<List<ProfileArticleEntity>>

    fun getMyComments(
        token: String,
        offset: Int,
        limit: Int
    ): Result<List<ProfileCommentEntity>>

    fun signOut(
        token: String,
        id: Int
    ): Result<SignOutResponseEntity>

    fun editProfile(
        token: String,
        nickname: String,
        description: String,
        insignia: List<String>
    ): Result<EditProfileResponseEntity>
}
