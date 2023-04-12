package com.devjj.platform.nurbanhoney.domain.profile.model

import com.devjj.platform.nurbanhoney.extension.empty

data class EditProfileResponse(val result: String) {
    companion object {
        val empty =
            EditProfileResponse(String.empty())
    }
}
