package com.devjj.platform.nurbanhoney.domain.article.model

import com.devjj.platform.nurbanhoney.extension.empty

data class RatingResponseEntity(val result: String) {
    companion object {
        val empty = RatingResponseEntity(String.empty())
    }
}
