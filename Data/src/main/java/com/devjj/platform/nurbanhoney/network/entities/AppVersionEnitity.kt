package com.devjj.platform.nurbanhoney.network.entities

import com.google.gson.annotations.SerializedName

data class AppVersionEnitity(
    @SerializedName("appversion")
    val version: String,
    @SerializedName("isUpdate")
    val isUpdate: Boolean
)
