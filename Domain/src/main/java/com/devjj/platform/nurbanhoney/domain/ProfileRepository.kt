package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.profile.model.*

interface ProfileRepository {
    fun getProfile(token: String): Result<Profile>
    fun getMyArticles(
        token: String,
        offset: Int,
        limit: Int
    ): Result<List<ProfileArticle>>

    fun getMyComments(
        token: String,
        offset: Int,
        limit: Int
    ): Result<List<ProfileComment>>

    fun signOut(
        token: String,
        id: Int
    ): Result<SignOutResponse>

    fun editProfile(
        token: String,
        nickname: String,
        description: String,
        insignia: List<String>
    ): Result<EditProfileResponse>
}
