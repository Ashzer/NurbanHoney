package com.devjj.platform.nurbanhoney.network.api

import com.devjj.platform.nurbanhoney.network.entities.ArticleEntity
import com.devjj.platform.nurbanhoney.network.entities.ArticlesPreviewEntity
import com.devjj.platform.nurbanhoney.network.entities.CommentEntity
import com.devjj.platform.nurbanhoney.network.entities.RatingsEntity
import com.devjj.platform.nurbanhoney.network.entities.SimpleResponseEntity
import retrofit2.Call
import retrofit2.http.*

internal interface ArticleApi {
    companion object {
        private const val BASE_BOARD = "/board"
        private const val ARTICLE = "/article"
        private const val LIKE = "/like"
        private const val DISLIKE = "/dislike"
        private const val COMMENTS = "/comment"
        private const val COMMENT = "/detail"
        private const val RATING = "/myrating"
    }

    @GET("$BASE_BOARD/{board}")
    fun getArticles(
        @Path("board") board: String,
        @Query("flag") flag: Int = 0,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<List<ArticlesPreviewEntity>>

    // @GET(NURBAN_ARTICLE)
    @GET("$BASE_BOARD/{board}$ARTICLE")
    fun getArticle(
        @Path("board") board: String,
        @Header("token") token: String,
        @Query("id") id: Int
    ): Call<ArticleEntity>

    @FormUrlEncoded
    @POST("$BASE_BOARD/{board}$ARTICLE$LIKE")
    fun postLike(
        @Path("board") board: String,
        @Header("token") token: String,
        @Field("articleId") id: Int
    ): Call<SimpleResponseEntity>

    @DELETE("$BASE_BOARD/{board}$ARTICLE$LIKE")
    fun cancelLike(
        @Path("board") board: String,
        @Header("token") token: String,
        @Query("articleId") id: Int
    ): Call<SimpleResponseEntity>

    @FormUrlEncoded
    @POST("$BASE_BOARD/{board}$ARTICLE$DISLIKE")
    fun postDislike(
        @Path("board") board: String,
        @Header("token") token: String,
        @Field("articleId") id: Int
    ): Call<SimpleResponseEntity>

    @DELETE("$BASE_BOARD/{board}$ARTICLE$DISLIKE")
    fun cancelDislike(
        @Path("board") board: String,
        @Header("token") token: String,
        @Query("articleId") id: Int
    ): Call<SimpleResponseEntity>

    @GET("$BASE_BOARD/{board}$ARTICLE$RATING")
    fun getRatings(
        @Path("board") board: String,
        @Header("token") token: String,
        @Query("articleId") articleId: Int
    ): Call<RatingsEntity>

    @FormUrlEncoded
    @POST("$BASE_BOARD/{board}$ARTICLE$COMMENTS")
    fun postComment(
        @Path("board") board: String,
        @Header("token") token: String,
        @Field("content") comment: String,
        @Field("articleId") id: Int
    ): Call<SimpleResponseEntity>

    @GET("$BASE_BOARD/{board}$ARTICLE$COMMENTS")
    fun getComments(
        @Path("board") board: String,
        @Query("articleId") id: Int,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<List<CommentEntity>>

    @DELETE("$BASE_BOARD/{board}$ARTICLE$COMMENTS")
    fun deleteComment(
        @Path("board") board: String,
        @Header("token") token: String,
        @Query("id") id: Int,
        @Query("articleId") articleId: Int
    ): Call<SimpleResponseEntity>

    @FormUrlEncoded
    @PATCH("$BASE_BOARD/{board}$ARTICLE$COMMENTS")
    fun updateComment(
        @Path("board") board: String,
        @Header("token") token: String,
        @Field("id") id: Int,
        @Field("content") content: String
    ): Call<SimpleResponseEntity>

    @GET("$BASE_BOARD/{board}$ARTICLE$COMMENTS$COMMENT")
    fun getComment(
        @Path("board") board: String,
        @Query("commentId") commentId: Int
    ): Call<CommentEntity>
}
