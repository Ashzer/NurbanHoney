package com.devjj.platform.nurbanhoney.network.entities

import com.google.gson.annotations.SerializedName
import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageUploadResultEntity
import java.net.URL

class UploadImageNetworkResponse(
    @SerializedName("result")
    val url: String?
) {

    fun toImageUploadResult() = ImageUploadResultEntity(URL(url))
    companion object {
        val empty = UploadImageNetworkResponse(
            null
        )
    }
}
