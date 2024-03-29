package com.devjj.platform.nurbanhoney.network.api

import com.devjj.platform.nurbanhoney.network.entities.ProfileArticleEntity
import com.devjj.platform.nurbanhoney.network.entities.ProfileCommentEntity
import com.devjj.platform.nurbanhoney.network.entities.ProfileEntity
import com.devjj.platform.nurbanhoney.network.entities.SimpleResponseEntity
import retrofit2.Call
import retrofit2.http.*

internal interface ProfileApi {
    companion object {
        private const val PROFILE = "profile"
        private const val PROFILE_EDIT = "profile/edit"
        private const val PROFILE_MYARTCIEL = "profile/myarticle"
        private const val PROFILE_MYCOMMENT = "profile/mycomment"
        private const val PROFILE_WITHDRAWAL = "profile/withdrawal"
    }

    @GET(PROFILE)
    fun getProfile(
        @Header("Authorization") token: String
    ): Call<ProfileEntity>

    @GET(PROFILE_MYARTCIEL)
    fun getMyArticles(
        @Header("Authorization") token: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<List<ProfileArticleEntity>>

    @GET(PROFILE_MYCOMMENT)
    fun getMyComments(
        @Header("Authorization") token: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<List<ProfileCommentEntity>>

    @DELETE(PROFILE_WITHDRAWAL)
    fun signOut(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): Call<SimpleResponseEntity>

    @FormUrlEncoded
    @PATCH(PROFILE_EDIT)
    fun editProfile(
        @Header("Authorization") token: String,
        @Field("nickname") nickname: String,
        @Field("description") description: String,
        @Field("insignia") insignia: List<String>
    ): Call<SimpleResponseEntity>
    /*POST
    @FormUrlEncoded
    @POST(ARTICLE_LIKE)
    fun postLike(
        @Header("Authorization") token: String,
        @Field("articleId") id: Int
    ): Call<SimpleResponseNetworkResponse>
*/
    /*DELETE
    @DELETE(ARTICLE_LIKE)
    fun cancelLike(
        @Header("Authorization") token: String,
        @Query("articleId") id: Int
    ): Call<SimpleResponseNetworkResponse>
*/
    /*GET
    @GET(ARTICLE_RATING)
    fun getRatings(
        @Header("Authorization") token: String,
        @Query("articleId") articleId: Int
    ): Call<RatingsNetworkResponse>
*/
    /*PATCH
    @FormUrlEncoded
    @PATCH(ARTICLE_COMMENTS)
    fun updateComment(
        @Header("Authorization") token: String,
        @Field("id") id: Int,
        @Field("content") content: String
    ): Call<SimpleResponseNetworkResponse>

    */
}
