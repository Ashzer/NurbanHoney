package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.google.gson.annotations.SerializedName

data class BoardEntity(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("address") val address: String
) {
    companion object {
        val empty = BoardEntity(-1, "", "")
    }

    fun toBoardEntity() = Board(id, name, address)
}
