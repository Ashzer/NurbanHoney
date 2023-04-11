package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.login.model.NurbanTokenEntity
import com.devjj.platform.nurbanhoney.domain.login.model.TokenStatusEntity

interface LoginRepository {
    fun getNurbanToken(type: String, kakaoKey: String): Result<NurbanTokenEntity>
    fun isTokenValid(token: String): Result<TokenStatusEntity>
}
