package org.devjj.platform.nurbanhoney.features.ui.login

data class NurbanTokenEntity(
    val token : String,
    val userId : Int,
    val error : String
)