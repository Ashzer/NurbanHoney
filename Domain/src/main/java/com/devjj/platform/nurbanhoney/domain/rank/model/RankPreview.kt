package com.devjj.platform.nurbanhoney.domain.rank.model

data class RankPreview(
    val id: Int,
    val userId: Int,
    val badge: String,
    val nickname: String,
    val insignia: List<String>?
)
