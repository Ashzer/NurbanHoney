package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.rank.model.Rank
import com.devjj.platform.nurbanhoney.domain.rank.model.RankPreview
import com.devjj.platform.nurbanhoney.extension.empty
import com.google.gson.annotations.SerializedName
import java.math.BigInteger

data class RankEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("totalLossCut") val totalLossCut: BigInteger?,
    @SerializedName("totalLikeCount") val totalLikes: Int?,
    @SerializedName("user") val user: User
) {
    data class User(
        @SerializedName("userId") val userId: Int,
        @SerializedName("badge") val badge: String,
        @SerializedName("nickname") val nickname: String,
        @SerializedName("insignia") val insignia: List<String>?
    )

    companion object {
        val empty =
            RankEntity(-1, BigInteger.ZERO, -1, User(-1, String.empty(), String.empty(), listOf()))
    }

    fun toRank() = Rank(
        id,
        totalLossCut ?: BigInteger.ZERO,
        totalLikes ?: -1,
        user.userId,
        user.badge,
        user.nickname,
        user.insignia
    )

    fun toRankSimple() = RankPreview(
        id,
        user.userId,
        user.badge,
        user.nickname,
        user.insignia
    )
}

// "id" : "int", "totalLossCut" : "bigint", "totalLikeCount" : "int", "User" : { "userId" : "Int", "badge" : "string", "nickname" : "string", "insignia" : "json"
