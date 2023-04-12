package com.devjj.platform.nurbanhoney.domain.article.model

import com.devjj.platform.nurbanhoney.extension.empty

data class RatingResponse(val result: String) {
    companion object {
        val empty = RatingResponse(String.empty())
    }
}
