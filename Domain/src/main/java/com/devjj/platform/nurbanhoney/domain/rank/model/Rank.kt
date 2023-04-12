package com.devjj.platform.nurbanhoney.domain.rank.model

import java.math.BigInteger

data class Rank(
    val id: Int,
    val totalLossCut: BigInteger,
    val totalLikes: Int,
    val userId: Int,
    val badge: String,
    val nickname: String,
    val insignia: List<String>?
)
