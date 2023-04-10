package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.board.model.BoardEntity
import com.google.gson.annotations.SerializedName

data class BoardNetworkResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("address") val address: String
) {
    companion object {
        val empty = BoardNetworkResponse(-1, "", "")
    }

    fun toBoardEntity() = BoardEntity(id, name, address)
}
