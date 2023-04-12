
package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.login.model.NurbanToken
import com.google.gson.annotations.SerializedName

data class LoginInfoEntity(
    @SerializedName("token") var token: String,
    @SerializedName("userId") var userId: Int,
    @SerializedName("error") var error: String?
) {

    companion object {
        val empty = LoginInfoEntity("", -1, "")
    }

    fun toNurbanToken() = NurbanToken(token, userId, error ?: "")
}
