package com.devjj.platform.nurbanhoney.network.entities

import com.google.gson.annotations.SerializedName
import org.devjj.platform.nurbanhoney.features.ui.textedit.ImageUploadResultEntity
import java.net.URL

class UploadImageNetworkResponse(
    @SerializedName("result")
    val url: String?
){

    fun toImageUploadResult() = ImageUploadResultEntity(URL(url))
    companion object {
        val empty = UploadImageNetworkResponse(
            null
        )
    }
}