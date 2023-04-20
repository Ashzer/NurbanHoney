package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.login.model.NurbanToken
import com.devjj.platform.nurbanhoney.domain.login.model.TokenStatus

interface LoginRepository {
    fun getNurbanToken(type: String, key: String): Result<NurbanToken>
    fun isTokenValid(token: String): Result<TokenStatus>
}
