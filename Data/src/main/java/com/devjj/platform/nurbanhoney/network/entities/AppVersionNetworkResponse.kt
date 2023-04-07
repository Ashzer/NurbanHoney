package com.devjj.platform.nurbanhoney.network.entities

import com.google.gson.annotations.SerializedName

data class AppVersionNetworkResponse(
    @SerializedName("appversion")
    val version: String,
    @SerializedName("isUpdate")
    val isUpdate: Boolean
)