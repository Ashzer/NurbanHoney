package com.devjj.platform.nurbanhoney.network.entities

import com.devjj.platform.nurbanhoney.domain.textedit.model.ImageUploadResult
import com.google.gson.annotations.SerializedName
import java.net.URL

class UploadedImageEntity(
    @SerializedName("result")
    val url: String?
) {

    fun toImageUploadResult() = ImageUploadResult(URL(url))
    companion object {
        val empty = UploadedImageEntity(
            null
        )
    }
}
