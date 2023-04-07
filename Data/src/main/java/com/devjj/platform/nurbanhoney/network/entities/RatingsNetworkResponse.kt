package com.devjj.platform.nurbanhoney.network.entities

import com.google.gson.annotations.SerializedName
import org.devjj.platform.nurbanhoney.features.ui.article.model.RatingsEntity

data class RatingsNetworkResponse(
    @SerializedName("likeCount") val likes: Int,
    @SerializedName("dislikeCount") val dislikes: Int,
    @SerializedName("myRating") val myRating: String?
) {
    fun toRatings() = RatingsEntity(likes, dislikes, myRating ?: "")

    companion object {
        val empty = RatingsNetworkResponse(0, 0, "")
    }
}