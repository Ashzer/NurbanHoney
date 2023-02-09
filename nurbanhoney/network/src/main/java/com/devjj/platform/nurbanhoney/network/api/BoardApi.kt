package com.devjj.platform.nurbanhoney.network.api

import com.devjj.platform.nurbanhoney.network.entities.BoardEntity
import retrofit2.Call
import retrofit2.http.GET

internal interface BoardApi {
    companion object {
        private const val BASE_BOARD = "/board"
        private const val ARTICLE = "/article"
        private const val UPLOAD_IMG = "/upload/image"
    }

    @GET("$BASE_BOARD")
    fun getBoards() : Call<List<BoardEntity>>
}