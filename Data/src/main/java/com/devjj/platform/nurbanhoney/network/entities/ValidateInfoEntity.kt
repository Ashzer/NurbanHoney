package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.login.model.TokenStatus
import com.google.gson.annotations.SerializedName

data class ValidateInfoEntity(
    @SerializedName("result")
    val isValid: Boolean?,
    @SerializedName("error")
    val error: String
) {
    companion object {
        val empty = ValidateInfoEntity(null, "")
    }

    fun toIsTokenValid() = TokenStatus(isValid)
}
