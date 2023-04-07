
package com.devjj.platform.nurbanhoney.network.entities

import com.google.gson.annotations.SerializedName
import org.devjj.platform.nurbanhoney.features.ui.login.NurbanTokenEntity

data class LoginNetworkResponse(
    @SerializedName("token") var token: String,
    @SerializedName("userId") var userId: Int,
    @SerializedName("error") var error: String?
) {

    companion object {
        val empty = LoginNetworkResponse("", -1, "")
    }

    fun toNurbanToken() = NurbanTokenEntity(token, userId , error ?: "")
}