package com.devjj.platform.nurbanhoney.domain.login.model

data class NurbanToken(
    val token: String,
    val userId: Int,
    val error: String
){
    companion object{
        val empty = NurbanToken("", 0, "")
    }
}
