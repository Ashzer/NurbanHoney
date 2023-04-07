package org.devjj.platform.nurbanhoney.features.ui.article.model

import com.devjj.platform.nurbanhoney.extension.empty


data class CommentResponseEntity(val result: String){
    companion object{
        val empty = CommentResponseEntity(String.empty())
    }
}