package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.article.model.Ratings
import com.google.gson.annotations.SerializedName

data class RatingsEntity(
    @SerializedName("likeCount") val likes: Int,
    @SerializedName("dislikeCount") val dislikes: Int,
    @SerializedName("myRating") val myRating: String?
) {
    fun toRatings() = Ratings(likes, dislikes, myRating ?: "")

    companion object {
        val empty = RatingsEntity(0, 0, "")
    }
}
