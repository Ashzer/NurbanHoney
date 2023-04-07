package com.devjj.platform.nurbanhoney.network.api

import com.devjj.platform.nurbanhoney.network.entities.ProfileArticleNetworkResponse
import com.devjj.platform.nurbanhoney.network.entities.ProfileCommentNetworkResponse
import com.devjj.platform.nurbanhoney.network.entities.ProfileNetworkResponse
import com.devjj.platform.nurbanhoney.network.entities.SimpleNetworkResponse
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
        @Header("token") token: String
    ): Call<ProfileNetworkResponse>

    @GET(PROFILE_MYARTCIEL)
    fun getMyArticles(
        @Header("token") token: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): Call<List<ProfileArticleNetworkResponse>>

    @GET(PROFILE_MYCOMMENT)
    fun getMyComments(
        @Header("token") token: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ) : Call<List<ProfileCommentNetworkResponse>>

    @DELETE(PROFILE_WITHDRAWAL)
    fun signOut(
        @Header("token") token: String,
        @Query("id") id: Int,
    ): Call<SimpleNetworkResponse>


    @FormUrlEncoded
    @PATCH(PROFILE_EDIT)
    fun editProfile(
        @Header("token") token: String,
        @Field("nickname") nickname: String,
        @Field("description") description: String,
        @Field("insignia") insignia: List<String>,
    ) : Call<SimpleNetworkResponse>
    /*POST
    @FormUrlEncoded
    @POST(ARTICLE_LIKE)
    fun postLike(
        @Header("token") token: String,
        @Field("articleId") id: Int
    ): Call<SimpleResponseNetworkResponse>
*/
    /*DELETE
    @DELETE(ARTICLE_LIKE)
    fun cancelLike(
        @Header("token") token: String,
        @Query("articleId") id: Int
    ): Call<SimpleResponseNetworkResponse>
*/
    /*GET
    @GET(ARTICLE_RATING)
    fun getRatings(
        @Header("token") token: String,
        @Query("articleId") articleId: Int
    ): Call<RatingsNetworkResponse>
*/
    /*PATCH
    @FormUrlEncoded
    @PATCH(ARTICLE_COMMENTS)
    fun updateComment(
        @Header("token") token: String,
        @Field("id") id: Int,
        @Field("content") content: String
    ): Call<SimpleResponseNetworkResponse>

    */
}