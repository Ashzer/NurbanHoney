package com.devjj.platform.nurbanhoney

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.devjj.platform.nurbanhoney.core.extension.tokenDataStore
import com.kakao.sdk.common.KakaoSdk
import dagger.hilt.android.HiltAndroidApp
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltAndroidApp
class AndroidApplication : Application() {
	override fun onCreate() {
		super.onCreate()
		KakaoSdk.init(this, getString(R.string.kakao_key))
	}
}

interface UserTokenRepository {
	fun getUserToken(): Flow<String?>
	suspend fun setUserToken(token: String)
}

class UserTokenRepositoryImpl
@Inject constructor(private val context: Context) : UserTokenRepository {
	override fun getUserToken(): Flow<String?> {
		return context.tokenDataStore.data.map { preferences ->
			val key = preferences[stringPreferencesKey("token")]
			Log.d("getUserToken", "key : $key")
			key
		}
	}

	override suspend fun setUserToken(token: String) {
		context.tokenDataStore.edit { preferences ->
			preferences[stringPreferencesKey("token")] = token
		}
	}
}