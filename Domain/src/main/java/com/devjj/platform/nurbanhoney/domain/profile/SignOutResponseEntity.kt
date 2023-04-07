package com.devjj.platform.nurbanhoney.domain.profile

import com.devjj.platform.nurbanhoney.extension.empty

data class SignOutResponseEntity(val result : String){
    companion object{
        val empty = SignOutResponseEntity(String.empty())
    }
}