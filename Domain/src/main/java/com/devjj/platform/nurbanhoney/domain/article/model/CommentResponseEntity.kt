package com.devjj.platform.nurbanhoney.domain.article.model

import com.devjj.platform.nurbanhoney.extension.empty

data class CommentResponseEntity(val result: String) {
    companion object {
        val empty = CommentResponseEntity(String.empty())
    }
}
