package com.devjj.platform.nurbanhoney.domain.profile.model

import com.devjj.platform.nurbanhoney.extension.empty

data class SignOutResponse(val result: String) {
    companion object {
        val empty = SignOutResponse(String.empty())
    }
}
