package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.profile.model.ProfileEntity
import com.devjj.platform.nurbanhoney.extension.empty
import com.google.gson.annotations.SerializedName

data class ProfileNetworkResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("loginType") val loginType: String,
    @SerializedName("badge") val badge: String?,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("description") val description: String?,
    @SerializedName("point") val point: Int,
    @SerializedName("insigniaShow") val insigniaShow: List<String>?,
    @SerializedName("insigniaOwn") val insigniaOwn: List<String>?,
    @SerializedName("myArticleCount") val myArticleCount: Int,
    @SerializedName("myCommentCount") val myCommentCount: Int,
    @SerializedName("error") val error: String?
) {
    fun toProfile() =
        ProfileEntity(
            id,
            loginType,
            badge,
            nickname,
            description,
            point,
            insigniaShow,
            insigniaOwn,
            myArticleCount,
            myCommentCount,
            error
        )

    companion object {
        val empty = ProfileNetworkResponse(
            0, String.empty(), String.empty(), String.empty(), String.empty(),
            0, listOf(), listOf(), 0, 0, String.empty()
        )
    }
}
