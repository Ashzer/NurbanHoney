
package com.devjj.platform.nurbanhoney.network.entities

import com.google.gson.annotations.SerializedName
import com.devjj.platform.nurbanhoney.domain.login.model.NurbanTokenEntity

data class LoginNetworkResponse(
    @SerializedName("token") var token: String,
    @SerializedName("userId") var userId: Int,
    @SerializedName("error") var error: String?
) {

    companion object {
        val empty = LoginNetworkResponse("", -1, "")
    }

    fun toNurbanToken() = NurbanTokenEntity(token, userId, error ?: "")
}
