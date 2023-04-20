package com.devjj.platform.nurbanhoney

import android.app.Application
import android.util.Log
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient

@HiltAndroidApp
class AndroidApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		KakaoSdk.init(this, getString(R.string.kakao_key))
	}
}
