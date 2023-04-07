package org.devjj.platform.nurbanhoney.features.ui.article.model

import com.devjj.platform.nurbanhoney.extension.empty

data class RatingResponseEntity(val result: String){
    companion object{
        val empty = RatingResponseEntity(String.empty())
    }
}