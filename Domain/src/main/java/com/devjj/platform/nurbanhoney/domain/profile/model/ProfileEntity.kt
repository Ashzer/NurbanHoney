package com.devjj.platform.nurbanhoney.domain.profile.model

import com.devjj.platform.nurbanhoney.extension.empty

data class ProfileEntity(
    val id: Int,
    val loginType: String,
    val badge: String?,
    val nickname: String,
    val description: String?,
    val point: Int,
    val insigniaShow: List<String>?,
    val insigniaOwn: List<String>?,
    val myArticleCount: Int,
    val myCommentCount: Int,
    val error: String?
) {
    companion object {
        var empty = ProfileEntity(
            0,
            String.empty(),
            String.empty(),
            String.empty(),
            String.empty(),
            0,
            listOf(),
            listOf(),
            0,
            0,
            String.empty()
        )
    }
}
