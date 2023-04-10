package com.devjj.platform.nurbanhoney.network.entities

import com.google.gson.annotations.SerializedName
import com.devjj.platform.nurbanhoney.domain.login.model.TokenStatusEntity

data class ValidationNetworkResponse(
    @SerializedName("result")
    val isValid: Boolean?,
    @SerializedName("error")
    val error: String
) {
    companion object {
        val empty = ValidationNetworkResponse(null, "")
    }

    fun toIsTokenValid() = TokenStatusEntity(isValid)
}
