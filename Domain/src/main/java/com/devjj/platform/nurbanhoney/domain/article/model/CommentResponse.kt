package com.devjj.platform.nurbanhoney.domain.article.model

import com.devjj.platform.nurbanhoney.extension.empty

data class CommentResponse(val result: String) {
    companion object {
        val empty = CommentResponse(String.empty())
    }
}
