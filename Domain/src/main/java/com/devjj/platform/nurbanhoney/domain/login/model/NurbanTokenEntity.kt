package com.devjj.platform.nurbanhoney.domain.login.model

data class NurbanTokenEntity(
    val token: String,
    val userId: Int,
    val error: String
)
