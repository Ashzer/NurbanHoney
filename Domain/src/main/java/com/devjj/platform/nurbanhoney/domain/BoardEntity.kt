package com.devjj.platform.nurbanhoney.domain

data class BoardEntity(
    val id: Int,
    val name: String,
    val address: String
) {
    companion object {
        val empty = BoardEntity(-1, "", "")
    }
}
