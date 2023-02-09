package com.devjj.platform.nurbanhoney.feature.ui

data class Board(
    val id : Int,
    val name : String,
    val address : String
){
    companion object {
        val empty = Board(-1, "Board doesn't exist", "")
    }
}
