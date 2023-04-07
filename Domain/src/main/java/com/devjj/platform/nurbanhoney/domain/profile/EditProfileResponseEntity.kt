package com.devjj.platform.nurbanhoney.domain.profile

import com.devjj.platform.nurbanhoney.extension.empty

data class EditProfileResponseEntity(val result : String){
    companion object{
        val empty = EditProfileResponseEntity(String.empty())
    }
}