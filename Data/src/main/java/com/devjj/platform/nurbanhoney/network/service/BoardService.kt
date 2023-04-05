package com.devjj.platform.nurbanhoney.network.service

import com.devjj.platform.nurbanhoney.network.api.BoardApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BoardService
@Inject constructor(retrofit: Retrofit) : BoardApi {
    private val boardApi by lazy { retrofit.create(BoardApi::class.java) }
    override fun getBoards() = boardApi.getBoards()
}
