package com.devjj.platform.nurbanhoney.domain.rank

import java.math.BigInteger

data class RankEntity(
    val id: Int,
    val totalLossCut: BigInteger,
    val totalLikes: Int,
    val userId: Int,
    val badge: String,
    val nickname: String,
    val insignia: List<String>?
)